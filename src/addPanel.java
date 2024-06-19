import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addPanel extends JPanel {
    JPanel whole, profile, information, menu, item;


    public addPanel() {

        // 전체 패널 생성 (전체 스크롤이 가능하도록)
        whole = new JPanel();
        whole.setLayout(new BoxLayout(whole, BoxLayout.Y_AXIS)); // 레이아웃 설정
        whole.setBackground(Color.WHITE); // 배경색 설정(흰색)






        // 전체 패널 스크롤 가능하게
        JScrollPane scrollPane = new JScrollPane(whole);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

}
