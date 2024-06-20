import java.io.*;

public class DataWriter {
    private String filepath = "lectureLost.csv";

    public int lecture_num() {
        int lecturenum = 0;
        DataReader reader = new DataReader();
        lecturenum = reader.getDataNum() + 1;
        return lecturenum;
    }

    public void WriteData(String name, String start, String end, String time) {
        File csv = new File(filepath);
        BufferedWriter bw = null;
        try {
            LogReader reader = new LogReader();
            int length = reader.getLogLength();

            bw = new BufferedWriter(new FileWriter(csv, true));


            for (int i = 0; i < length; i++) {
                String data = "";
                data = data.join(",", String.valueOf(lecture_num()), name, start, end, time,
                        reader.getList().get(i).get("lost"), reader.getList().get(i).get("regained"));
                bw.newLine();
                bw.write(data);
            }

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
