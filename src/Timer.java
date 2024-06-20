import javax.swing.*;
import java.awt.*;

public class Timer {

    private long startTime;
    private boolean run;
    private boolean resume;
    private int hour;
    private int minute;
    private int second;

    public void start(JPanel panel) {
        startTime = System.currentTimeMillis();
        run = true;
        resume = false;
        hour = 0;
        minute = 0;
        second = 0;

        Thread thread = new Thread(() -> {
            while(run) {
                long currentTime = System.currentTimeMillis() - startTime;

                if(currentTime < 1000) {
                    second = 0;
                }
                else if(currentTime < 60000) {
                    second = (int)currentTime/1000;
                }
                else if(currentTime < 3600000) {
                    minute = (int)currentTime/60000;
                    int mleft = (int)currentTime%60000;
                    second = mleft/1000;
                }
                else if (currentTime < 21600000) {
                    hour = (int)currentTime/3600000;
                    int hleft = (int)currentTime%3600000;
                    minute = hleft/60000;
                    int mleft = hleft%60000;
                    second = (int)currentTime/1000;
                }

                String timestr = hour + ":" + minute + ":" + second;
                JLabel label = new JLabel(timestr);
                Font font = new Font(null, Font.PLAIN, 20);
                label.setFont(font);
                SwingUtilities.invokeLater(() -> {
                    panel.removeAll();
                    panel.add(label);
                    panel.revalidate();  // 패널을 다시 그리도록 함
                    panel.repaint();     // 패널을 다시 그리도록 함
                });
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public void resume() {
    }

    public void stop() {
        run = false;
    }

}
