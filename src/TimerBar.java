import javax.swing.*;
import java.awt.*;

public class TimerBar {

    private boolean run;
    private float widthcal;
    private int width;
    private int height;
    private JLabel timebar;
    private JPanel panel;

    public TimerBar(JPanel panel) {
        this.panel = panel;
        width = 0;
        height = 50;
    }
    public void start(int sec, JPanel panel) {
        run = true;
        width = 0;
        widthcal = 0;

        timebar = new JLabel();
        timebar.setBackground(new Color(0xBBDEFB));
        timebar.setOpaque(true);
        timebar.setPreferredSize(new Dimension(width, height));

        panel.add(timebar);

        Thread thread = new Thread(() -> {
            while(run) {
                if(timebar.getWidth() < 600) {
                    widthcal += 600.0 / sec;
                    width = -(int)(600 / sec) + (int)widthcal;
                    timebar.setPreferredSize(new Dimension(width, height));

                    SwingUtilities.invokeLater(() -> {
                        panel.revalidate();  // 패널을 다시 그리도록 함
                        panel.repaint();     // 패널을 다시 그리도록 함
                    });
                }
                else break;

                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public void stop() {
        run = false;
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

}