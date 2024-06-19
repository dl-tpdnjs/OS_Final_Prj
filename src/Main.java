import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel startPanel = new JPanel();
        TimerPanel2 analysisPanel = new TimerPanel2("C:\\SHE_Project\\Java\\SM_OPENSOURCE\\opensource2\\lectureLost.csv");

        JTabbedPane pane = new JTabbedPane();

        pane.addTab("집중도 측정", startPanel);
        pane.addTab("집중도 보고서", analysisPanel); //보고서 탭

        add(pane);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}