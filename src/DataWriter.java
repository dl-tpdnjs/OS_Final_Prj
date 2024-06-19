import java.io.*;

public class DataWriter {
    private String filepath = "C:\\SHE_Project\\Java\\SM_OPENSOURCE\\opensource2\\data.csv";

    public int lecture_num() {
        int lecturenum = 0;
        DataReader reader = new DataReader();
        lecturenum = reader.getDataNum() + 1;
        return lecturenum;
    }

    public String lecture_name() {
        String lecturename = null;
        StartPanel start = new StartPanel();
        lecturename = start.lecture_name;
        return lecturename;
    }

    public String lecture_time() {
        String lecturetime = null;
        StartPanel start = new StartPanel();
        lecturetime = start.lecture_time;
        return lecturetime;
    }

    public String button_start() {
        String buttonstart = null;
        StartPanel start = new StartPanel();
        buttonstart = start.lec_start;
        return buttonstart;
    }

    public void WriteData(String name, String start, String time) {
        File csv = new File(filepath);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csv, true));
            String data = "";
            data = data.join(",", String.valueOf(lecture_num()), name, start, null, time, null, null);
            bw.newLine();
            bw.write(data);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
