import javax.swing.*;
import java.awt.*;

public class TimerBar {

    private boolean run;
    private float widthcal;
    private int width;
    private int height;
    private JLabel timebar;

    public TimerBar() {
        width = 0;
        height = 50;
        timebar = new JLabel();
        timebar.setBackground(new Color(0xBBDEFB));
        timebar.setOpaque(true);
        timebar.setPreferredSize(new Dimension(width, height));
    }
    public void start(int sec, JPanel panel) {
        run = true;
        width = 0;
        widthcal = 0;
        panel.removeAll();

        Thread thread = new Thread(() -> {
            while(run) {
                if(timebar.getWidth() < 600) {
                    widthcal += 600.0 / sec;
                    width = -(int)(600 / sec) + (int)widthcal;
                    timebar.setPreferredSize(new Dimension(width, height));

                    SwingUtilities.invokeLater(() -> {
                        panel.removeAll();
                        panel.add(timebar);
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
    }

}