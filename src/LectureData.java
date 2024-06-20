// 강의 데이터를 저장하는 클래스
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



class LectureData {
    private String lectureName;
    private int buttonDuration;
    private int lectureDuration;
    private List<int[]> highlightTimes;

    public LectureData(String lectureName, int buttonDuration, int lectureDuration) {
        this.lectureName = lectureName;
        this.buttonDuration = buttonDuration;
        this.lectureDuration = lectureDuration;
        this.highlightTimes = new ArrayList<>();
    }

    public void addHighlightTime(int[] time) {
        highlightTimes.add(time);
    }

    public List<int[]> getHighlightTimes() {
        return highlightTimes;
    }

    public List<int[]> getAdjustedHighlightTimes() {
        List<int[]> adjustedTimes = new ArrayList<>();
        for (int[] time : highlightTimes) {
            adjustedTimes.add(new int[]{time[0], time[1]});
        }
        return adjustedTimes;
    }

    public String getLectureName() {return lectureName;}

    public int getButtonDuration() {
        return buttonDuration;
    }

    public int getLectureDuration() {
        return lectureDuration;
    }
}