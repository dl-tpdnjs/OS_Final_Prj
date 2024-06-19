import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;

public class Main_All_test extends JFrame {

    private JTabbedPane pane;
    private TimerPanel3 analysisPanel;

    public Main_All_test() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        // 주연님 이 부분에 주연님 패널 넣으면 됩니다!
        StartPanel startPanel = new StartPanel();


        analysisPanel = new TimerPanel3("C:\\SHE_Project\\Java\\SM_OPENSOURCE\\opensource2\\lectureLost.csv");

        pane = new JTabbedPane();
        pane.setBackground(new Color(0xe8e2db));
        pane.setFont(new Font("NPS font", Font.PLAIN, 15));
        pane.addTab("집중도 측정", startPanel);
        pane.addTab("집중도 보고서", analysisPanel); //보고서 탭

        pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = pane.getSelectedIndex();
                if (selectedIndex == 1 && analysisPanel != null) {
                    // 보고서 탭이 선택되었을 때, 파일을 다시 읽어오도록 함
                    analysisPanel.reloadFile();
                }
            }
        });

        add(pane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main_All_test().setVisible(true);
            }
        });
    }
}