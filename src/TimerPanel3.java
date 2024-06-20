import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.*;

class TimerPanel3 extends JPanel {
    private List<SegmentedBar> segmentedBars; // SegmentedBar 객체들을 담을 리스트
    private String filePath;
    private volatile boolean shouldReload; // 파일 변경 감지 플래그
    private JLabel label;
    private JPanel mainPanel; // 메인 패널 필드 추가
    private Font defaultFont = new Font("NPS font", Font.PLAIN, 15);
    private Color backgroundColor = new Color(0xe8e2db);
    private Color highlightColor = new Color(0xf5564e);


    // 생성자
    public TimerPanel3(String csvFilePath) {
        segmentedBars = new ArrayList<>(); // SegmentedBar 리스트 초기화
        this.filePath = csvFilePath;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // 수직 정렬을 위해 BoxLayout 설정

        try {
            Map<Integer, LectureData> lectureDataMap = readCSV(csvFilePath); // CSV 파일을 읽어 LectureData 맵 생성

            // 초기화된 메인 패널 생성
            mainPanel = createMainPanel(lectureDataMap);
            mainPanel.setBackground(Color.WHITE);

            // JScrollPane 생성 및 설정
            JScrollPane scrollPane = new JScrollPane(mainPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // TimerPanel3에 JScrollPane 추가
            add(scrollPane);

            // 파일 변경 감지 스레드 시작
            Thread fileWatcherThread = new Thread(new FileWatcher());
            fileWatcherThread.start();

        } catch (IOException | ParseException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }

    // 메인 패널을 생성하는 메서드
    private JPanel createMainPanel(Map<Integer, LectureData> lectureDataMap) {
        JPanel mainPanel = new JPanel(); // 전체 패널 생성
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        // LectureData 맵을 순회하며 각각의 데이터에 대해 처리
        for (Map.Entry<Integer, LectureData> entry : lectureDataMap.entrySet()) {
            LectureData lectureData = entry.getValue(); // 현재 반복 중인 LectureData 객체 가져오기

            JPanel lecturePanel = new JPanel();
            lecturePanel.setLayout(new BoxLayout(lecturePanel, BoxLayout.Y_AXIS));
            lecturePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            lecturePanel.setBackground(Color.WHITE);

            // 강의 이름 라벨 추가
            lecturePanel.add(createLectureNameLabel(lectureData.getLectureName()));

            // 집중하지 않은 시간대 바 생성 및 추가
            SegmentedBar buttonBar = new SegmentedBar(lectureData.getButtonDuration(), lectureData.getHighlightTimes(), lectureData.getLectureDuration(), backgroundColor, highlightColor);
            segmentedBars.add(buttonBar);
            lecturePanel.add(buttonBar);

            // 집중하지 않은 시간을 표시하는 라벨 생성 및 추가
            lecturePanel.add(createHighlightLabel(lectureData.getHighlightTimes()));

            // 실제 강의 시간을 표시하는 라벨 생성 및 추가
            lecturePanel.add(RealLectureTime(lectureData.getHighlightTimes()));

            // 실제 강의에서 복습해야하는 부분을 표시하는 라벨 생성 및 추가
            lecturePanel.add(createRestudyLabel(lectureData.getHighlightTimes()));

            // 강의 패널을 mainPanel에 추가
            mainPanel.add(lecturePanel);

            // 강의 패널 간 간격 추가
            mainPanel.add(Box.createVerticalStrut(10)); // 10 픽셀 간격 추가
        }

        return mainPanel;
    }

    // CSV 파일을 읽어 LectureData 맵으로 반환하는 메서드
    private Map<Integer, LectureData> readCSV(String csvFilePath) throws IOException, ParseException {
        Map<Integer, LectureData> lectureDataMap = new HashMap<>(); // LectureData 객체를 담을 맵 생성

        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath)); // 파일 리더 생성
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // 시간 포맷 지정

        // 첫 줄은 헤더이므로 건너뜀
        reader.readLine();

        // 파일을 한 줄씩 읽어서 처리
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(","); // 쉼표로 데이터 분리
            int lectureNum = Integer.parseInt(data[0]); // 강의 번호 파싱
            String lectureName = data[1]; // 강의 이름
            int buttonStart = calculateSecondsFromTimeString(data[2], sdf); // 버튼 시작 시간
            int buttonEnd = calculateSecondsFromTimeString(data[3], sdf); // 버튼 종료 시간
            int lectureDuration = calculateSecondsFromTimeString(data[4], sdf); // 강의 시간
            int lostStart = calculateSecondsFromTimeString(data[5], sdf); // 집중하지 않은 시작 시간
            int lostEnd = calculateSecondsFromTimeString(data[6], sdf); // 집중하지 않은 종료 시간

            // 버튼 누름 시간 계산 (초 단위)
            int buttonDuration = buttonEnd - buttonStart;
            // 강의 시간 계산 (초 단위)
            int lectureDurationSeconds = lectureDuration;
            // 집중하지 않은 시간의 시작과 종료 시간을 초 단위로 계산
            int highlightStart = lostStart - buttonStart; // 집중하지 않은 시작 시간 계산
            int highlightEnd = lostEnd - lostStart; // 집중하지 않은 종료 시간 계산

            int highlightTime = lostEnd - buttonStart;

            int lostTime = highlightEnd - highlightStart;
            int lecLostremove = (lectureDurationSeconds - lostTime);

            System.out.println("집중하지 않은 시작 시간 계산 : " + highlightStart);
            System.out.println("집중하지 않은 종료 시간 계산 : " + highlightEnd);
            System.out.println("하이라이트 시간 간격 계산 : " + highlightTime);
            System.out.println("실제 강의 시간 : " + lectureDuration);
            System.out.println("실제 강의에서 다시 복습할 시간 : " + lecLostremove);


            // LectureData 맵에 강의 번호를 키로 하는 추가
            lectureDataMap.computeIfAbsent(lectureNum, k -> new LectureData(lectureName, buttonDuration, lectureDurationSeconds))
                    .addHighlightTime(new int[]{highlightStart, highlightTime, highlightEnd, lecLostremove,lectureDurationSeconds}); // 집중하지 않은 시간 추가
        }

        reader.close(); // 리더 닫기
        return lectureDataMap; // LectureData 맵 반환
    }

    private JLabel createLectureNameLabel(String lectureName) {
        JLabel name = new JLabel("< " + lectureName + " >");
        name.setBackground(new Color(0x003b6f));
        name.setFont(new Font("NPS font", Font.BOLD, 20));
        return name;
    }

    // 집중하지 않은 시간을 표시하는 라벨 생성하는 메서드
    private JLabel createHighlightLabel(List<int[]> highlightTimes) {
        StringBuilder labelText = new StringBuilder("집중하지 못한 시간: ");
        for (int[] highlight : highlightTimes) {
            int highlightStart = highlight[0]; // 집중하지 않은 시작 시간
            int highlightEnd = highlight[1]; // 집중하지 않은 종료 시간

            System.out.println("집중하지 않은 시작 시간 계산 : " + highlightStart);
            System.out.println("집중하지 않은 종료 시간 계산 : " + highlightEnd);

            // 집중하지 않은 시작 시간과 종료 시간을 포맷
            String startTime = formatSecondsToHHMMSS(highlightStart);
            String endTime = formatSecondsToHHMMSS(highlightEnd);

            // 라벨 텍스트에 추가
            labelText.append(startTime).append(" - ").append(endTime).append(", ");
        }

        // 마지막 콤마 제거
        if (labelText.length() > 0) {
            labelText.setLength(labelText.length() - 2);
        }

        JLabel label = new JLabel(labelText.toString());
        label.setFont(defaultFont); // 폰트 설정

        return label; // 완성된 라벨 반환
    }

    // 집중하지 않은 시간을 표시하는 라벨 생성하는 메서드
    private JLabel RealLectureTime(List<int[]> highlightTimes) {
        StringBuilder labelText = new StringBuilder("실제 강의 시간 : ");

        for (int[] highlight : highlightTimes) {
            int lectureDurationSeconds = highlight[4]; // 집중하지 않은 종료 시간

            System.out.println("집중하지 않은 종료 시간 계산1 : " + lectureDurationSeconds);

            // 집중하지 않은 시작 시간과 종료 시간을 포맷
            String lecTime = formatSecondsToHHMMSS(lectureDurationSeconds);

            // 라벨 텍스트에 추가
            labelText.append(lecTime).append(", ");
        }

        // 마지막 콤마 제거
        if (labelText.length() > 0) {
            labelText.setLength(labelText.length() - 2);
        }
        // 첫 번째 콤마의 위치 찾기
        int commaIndex = labelText.indexOf(",");

        // 첫 번째 콤마 앞의 부분 문자열 추출
        String labelTextBeforeFirstComma = labelText.substring(0, commaIndex);

        JLabel label = new JLabel(labelTextBeforeFirstComma.toString());
        label.setFont(defaultFont); // 폰트 설정

        return label; // 완성된 라벨 반환
    }

    // 집중하지 않은 시간을 표시하는 라벨 생성하는 메서드
    private JLabel createRestudyLabel(List<int[]> highlightTimes) {
        StringBuilder labelText = new StringBuilder("실제 강의에서 다시 복습해야 할 부분 : ");
        for (int[] highlight : highlightTimes) {
            int lectureDurationSeconds = highlight[4];
            int lecLostremove = highlight[3]; // 집중하지 않은 종료 시간


            int lecStudy = lecLostremove - lectureDurationSeconds;
            System.out.println("집중하지 않은 종료 시간 계산1 : " + lecStudy);
            if (lecStudy <= 0) {
                lecStudy = lecStudy * -1;
            }

            // 실제 강의 시간보다 집중력을 잃은 시간이 더 길지 않은 경우에만 처리
            if (lecStudy <= lectureDurationSeconds) {
                System.out.println("집중하지 않은 종료 시간 계산1 : " + lecStudy);

                // 집중하지 않은 시작 시간과 종료 시간을 포맷
                String lecTime = formatSecondsToHHMMSS(lecStudy);

                // 라벨 텍스트에 추가
                labelText.append(lecTime).append(", ");
            }
        }

        // 마지막 콤마 제거
        if (labelText.length() > 0) {
            labelText.setLength(labelText.length() - 2);
        }

        JLabel label = new JLabel(labelText.toString());
        label.setFont(defaultFont); // 폰트 설정

        return label; // 완성된 라벨 반환

    }

    // 초를 시간 포맷으로 변환하는 메서드
    private String formatSecondsToHHMMSS(int seconds) {
        int hours = seconds / 3600; // 시간 계산
        int minutes = (seconds % 3600) / 60; // 분 계산
        int secs = seconds % 60; // 초 계산
        return String.format("%02d:%02d:%02d", hours, minutes, secs); // 포맷에 맞춰 문자열 반환
    }

    // 버튼 시작 시간 문자열을 초 단위로 계산하는 메서드
    private int calculateSecondsFromTimeString(String timeString, SimpleDateFormat sdf) throws ParseException {
        Date date = sdf.parse(timeString); // 시간 문자열을 Date 객체로 파싱

        // 정규 표현식 패턴 설정
        Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
        Matcher matcher = pattern.matcher(timeString); // 시간 문자열에 대해 Matcher 생성

        int seconds = 0;
        // 매칭된 패턴이 있으면 시간, 분, 초를 추출
        if (matcher.find()) {
            int hour = Integer.parseInt(matcher.group(1)); // HH 추출 후 int로 변환
            int minute = Integer.parseInt(matcher.group(2)); // MM 추출 후 int로 변환
            int second = Integer.parseInt(matcher.group(3)); // SS 추출 후 int로 변환

            // 시간 문자열을 실제 초 단위로 바꾸기
            seconds = hour * 3600 + minute * 60 + second;
        } else {
            throw new IllegalArgumentException("Invalid time format: " + timeString);
        }

        return seconds; // 초 단위로 변환된 값을 반환
    }

    // 파일 변경 감지 스레드
    private class FileWatcher implements Runnable {
        @Override
        public void run() {
            try {
                Path path = Paths.get(new File(filePath).getAbsolutePath());
                WatchService watchService = FileSystems.getDefault().newWatchService();
                path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

                while (true) {
                    WatchKey key = watchService.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                            Path changed = (Path) event.context();
                            if (changed.toString().equals(path.getFileName().toString())) {
                                // 파일 변경 감지됨
                                shouldReload = true;
                                break;
                            }
                        }
                    }
                    key.reset();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 파일 다시 읽기
    // 파일 다시 읽기
    public void reloadFile() {
        if (shouldReload) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 새로운 CSV 파일을 읽어 LectureData 맵 생성
                        Map<Integer, LectureData> lectureDataMap = readCSV(filePath);

                        // 기존 패널 제거
                        removeAll();

                        // 새로운 메인 패널 생성
                        mainPanel = createMainPanel(lectureDataMap);
                        JScrollPane scrollPane = new JScrollPane(mainPanel);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        add(scrollPane);

                        revalidate(); // 컴포넌트 레이아웃 재구성
                        repaint(); // 컴포넌트를 다시 그리도록 요청
                    } catch (IOException | ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            shouldReload = false; // 감지 플래그 초기화
        }
    }

}
