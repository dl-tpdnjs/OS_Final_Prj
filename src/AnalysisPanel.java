import javax.swing.*;
import java.awt.*;


public class AnalysisPanel extends JPanel {

    DataReader data = new DataReader(); //csv 파일의 마지막 줄 lecture_num 값을 int로 반환

    public AnalysisPanel() {
        int datanum = data.getDataNum(); //강의 개수

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 200 * datanum));

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new FlowLayout());
        mainpanel.setPreferredSize(new Dimension(800, 200 * datanum));

        System.out.println(datanum);

        for(int i = 0 ; i < datanum ; i++) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(800, 200));
            panel.setBackground(Color.WHITE);
            mainpanel.add(panel);
        }

        JScrollPane scroll = new JScrollPane(mainpanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scroll);
    }
}