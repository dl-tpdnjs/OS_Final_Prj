import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DataReader {

    //csv 파일의 마지막 줄 lecture_num을 읽어와 int 형식으로 반환
    public int getDataNum() {
        int num = 0;
        Map<String, String> lastline = getList().getLast(); //csv 파일 마지막 줄의 Map
        try {
            num = Integer.parseInt(lastline.get("lecture_num")); //lastline Map에서 lecture_num에 대응되는 값을 int로 형변환, num에 저장
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return num;
    }

    //csv 파일 전체를 읽어 Vector<Map<String, String>> 형식으로 저장
    private Vector<Map<String, String>> getList() {
        Vector<Map<String, String>> allList = new Vector<>();
        File csv = new File("lectureLost.csv");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csv),"UTF-8"));
            String[] headers = br.readLine().split(","); //파일 첫 번째 줄 헤더로 설정

            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> datainfo = new HashMap<>();
                for(int i = 0 ; i < headers.length ; i++) {
                    datainfo.put(headers[i], values[i]); //파일 데이터 값을 읽어와 헤더와 대응되도록 (header, value) 형식으로 저장
                }
                allList.add(datainfo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return allList;
    }
}
