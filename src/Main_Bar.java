import javax.swing.*;
import java.awt.*;

public class Main_Bar extends JPanel {
    public Main_Bar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // 레이아웃 설정
        setBackground(Color.WHITE); // 배경색 설정(흰색)

        // TimerPanel을 생성하여 this 패널에 추가
        TimerPanel2 timerPanel = new TimerPanel2("C:\\SHE_Project\\Java\\SM_OPENSOURCE\\opensource2\\lectureLost.csv");
        add(timerPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("강의 타이머");
                frame.setSize(650, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                // Main_Bar 패널 생성
                Main_Bar mainPanel = new Main_Bar();

                // 전체 패널 스크롤 가능하게
                JScrollPane scrollPane = new JScrollPane(mainPanel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                // JFrame에 scrollPane 추가
                frame.add(scrollPane);

                frame.setVisible(true);
            }
        });
    }
}
