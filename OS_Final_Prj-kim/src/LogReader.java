import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class LogReader {

    public int getLogLength() {
        int length = getList().size();
        return length;
    }

    public Vector<Map<String, String>> getList() {
        Vector<Map<String, String>> allList = new Vector<>();
        File csv = new File("log.csv"); //ActivatePy.java에서 12번째 줄 주석 처리 해제 시 "eye_tracker.py 디렉토리/log.csv"로 수정
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
