import javax.swing.*;
import java.awt.*;
import java.util.List;

// 하이라이트가 있는 바를 표시하는 JPanel 클래스
class SegmentedBar extends JPanel {
    private int totalSeconds;
    private List<int[]> highlightTimes;
    private Color mainColor;
    private Color highlightColor;
    private int lecutre_time;

    public SegmentedBar(int totalSeconds, List<int[]> highlightTimes, int lecutre_time, Color mainColor, Color highlightColor) {
        this.totalSeconds = totalSeconds;
        this.highlightTimes = highlightTimes;
        this.mainColor = mainColor;
        this.highlightColor = highlightColor;
        this.lecutre_time = lecutre_time;


        setPreferredSize(new Dimension(600, 50)); // 전체 바의 크기 설정
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int totalWidth = getWidth();
        int height = getHeight();

        // 전체 바를 메인 색상으로 칠함
        g.setColor(mainColor);
        g.fillRect(0, 0, totalWidth, height);

        // 실제 강의 시간을 다른 색상으로 칠함 (예: 파란색)
        g.setColor(new Color(100, 200, 200));
        int lectureWidth = (int) ((double) lecutre_time / totalSeconds * totalWidth);
        g.fillRect(0, 0, lectureWidth, height);

        // 하이라이트 구간을 다른 색상으로 칠함 (예: 빨간색)
        g.setColor(highlightColor);
        for (int[] highlightTime : highlightTimes) {
            System.out.print("하이라이트 시작 시간 : ");
            System.out.println(highlightTime[0]);

            int highlightStart = (int) ((double) highlightTime[0] / totalSeconds * totalWidth);
            int highlightWidth = (int) ((double) (highlightTime[1] - highlightTime[0]) / totalSeconds * totalWidth);
            g.fillRect(highlightStart, 0, highlightWidth, height);
        }
    }

}
