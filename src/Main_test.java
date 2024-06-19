import javax.swing.*;
import java.awt.*;

public class Main_test {
    public Main_test() {
        JFrame frame = new JFrame("강의 타이머");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Main_Bar 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // 레이아웃 설정
        mainPanel.setBackground(Color.WHITE); // 배경색 설정(흰색)

        // TimerPanel을 생성하여 mainPanel에 추가
        TimerPanel2 timerPanel = new TimerPanel2("C:\\SHE_Project\\Java\\SM_OPENSOURCE\\opensource2\\lectureLost.csv");
        mainPanel.add(timerPanel);

        // mainPanel을 감싸는 JScrollPane 생성
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 막기

        // JScrollPane을 JFrame에 추가
        frame.add(scrollPane);

        // 프레임 크기 설정
        frame.setPreferredSize(new Dimension(650, 400)); // 프레임 크기 지정
        frame.pack(); // 컴포넌트 크기에 맞게 프레임 크기 자동 조정
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_Bar::new);
    }
}

