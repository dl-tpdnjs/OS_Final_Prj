import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StartPanel extends JPanel {
    public String lecture_name;
    public String lecture_time;
    public String lec_start;
    public String lec_end;
    private Font defaultFont = new Font("NPS font", Font.PLAIN, 15);
    private Color mainColor = new Color(0x1a3263);
    private Color whiteColor = Color.WHITE;

    public StartPanel() {
        Timer timer = new Timer();

        setSize(800, 600);

        JPanel uppanel = new JPanel();
        uppanel.setLayout(new FlowLayout());
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(new FlowLayout());
        JPanel downpanel = new JPanel();

        Dimension size1 = new Dimension(800, 200);
        uppanel.setPreferredSize(size1);
        centerpanel.setPreferredSize(size1);
        downpanel.setPreferredSize(size1);

        Dimension size2 = new Dimension(800, 50);
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(size2);
        panel1.setLayout(new FlowLayout());

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(size2);
        panel2.setLayout(new FlowLayout());

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(size2);
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 0));

        JPanel panel4 = new JPanel();
        panel4.setPreferredSize(size2);
        panel4.setLayout(new FlowLayout());

        TimerBar timerbar = new TimerBar(panel3);

        //uppanel 시작
        JLabel titlelabel = new JLabel("수강할 강의명을 입력해주세요.");
        titlelabel.setFont(defaultFont);
        titlelabel.setForeground(mainColor);

        JTextField titlefield = new JTextField(15);
        titlefield.setFont(defaultFont);
        titlefield.setForeground(mainColor);

        JButton titlebutton = new JButton("확인");
        titlebutton.setFont(defaultFont);
        titlebutton.setForeground(whiteColor);
        titlebutton.setBackground(mainColor);

        titlebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lecture_name = titlefield.getText();
                System.out.println("강의명: " + lecture_name);
            }
        });

        JLabel timelabel = new JLabel("수강할 강의 시간을 입력해주세요.");
        timelabel.setFont(defaultFont);
        timelabel.setForeground(mainColor);

        JTextField timefield = new JTextField("00:00:00", 15);
        timefield.setFont(defaultFont);
        timefield.setForeground(mainColor);

        JButton timebutton = new JButton("확인");
        timebutton.setFont(defaultFont);
        timebutton.setForeground(whiteColor);
        timebutton.setBackground(mainColor);

        timebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lecture_time = timefield.getText();
                System.out.println("강의 시간: " + lecture_time);
            }
        });

        panel1.add(titlelabel);
        panel1.add(titlefield);
        panel1.add(titlebutton);
        panel2.add(timelabel);
        panel2.add(timefield);
        panel2.add(timebutton);

        uppanel.add(panel1);
        uppanel.add(panel2);

        //centerpanel 시작
        JButton startBt = new JButton("시작");
        startBt.setFont(defaultFont);
        startBt.setForeground(whiteColor);
        startBt.setBackground(mainColor);

        JButton endBt = new JButton("종료");
        endBt.setFont(defaultFont);
        endBt.setForeground(whiteColor);
        endBt.setBackground(mainColor);

        endBt.setVisible(false);

        startBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //강의명, 강의 시간 입력 받지 못한 경우에 알림창 뜨도록 설정
                if(lecture_name == null || lecture_time == null) {
                    JOptionPane.showMessageDialog(null, "강의명, 강의 시간을 입력 후 확인 버튼을 눌러주세요.", "Message", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    //python 파일 실행 시작
                    ActivatePy.start();

                    //시작 시간 저장, 출력
                    LocalTime now = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    lec_start = now.format(formatter);
                    System.out.println("시작 시간: " + lec_start);

                    //타이머 시작
                    timer.start(panel4);

                    //입력 받은 강의 시간 초로 변환
                    String[] time = lecture_time.split(":");
                    int hour = Integer.valueOf(time[0]);
                    int min = Integer.valueOf(time[1]);
                    int sec = Integer.valueOf(time[2]);
                    sec = hour * 3600 + min * 60 + sec;

                   //변환한 시간 출력
                    System.out.println(sec);
                    
                    //타이머 바 시작
                    timerbar.start(sec, panel3);

                    startBt.setVisible(false);
                    endBt.setVisible(true);
                }

            }
        });

        endBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //python 파일 실행 중단
                ActivatePy.end();

                //종료 시간 저장, 출력
                LocalTime now = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                lec_end = now.format(formatter);
                System.out.println("종료 시간: " + lec_end);

                //타이머 중단
                timer.stop();
                timerbar.stop();

                //csv 파일에 데이터 입력
                DataWriter writer = new DataWriter();
                writer.WriteData(lecture_name, lec_start, lec_end, lecture_time);

                endBt.setVisible(false);
                startBt.setVisible(true);
            }
        });

        centerpanel.add(startBt);
        centerpanel.add(endBt);

        //downpanel 시작

        downpanel.add(panel3);
        downpanel.add(panel4);

        add(uppanel);
        add(centerpanel);
        add(downpanel);
    }
}
