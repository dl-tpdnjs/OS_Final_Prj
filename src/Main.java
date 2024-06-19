import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartPanel startPanel = new StartPanel();
        AnalysisPanel analysisPanel = new AnalysisPanel();

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("집중도 측정", startPanel);
        pane.addTab("집중도 보고서", analysisPanel); //보고서 탭

        add(pane);
    }

    //public static void main(String[] args) {
        //Main main = new Main();
        //main.setVisible(true);
    //}
}