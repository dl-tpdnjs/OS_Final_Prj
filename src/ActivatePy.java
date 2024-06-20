import java.io.File;
import java.io.IOException;

public class ActivatePy {

    private static Process process;

    public static void start() {
        try {
            String virtualPath = "가상 환경 경로/python.exe"; //가상 환경 경로 설정
            ProcessBuilder builder = new ProcessBuilder(virtualPath, "eye_tracker.py 경로/eye_tracker.py"); //eye_tracker.py 경로 설정
            //builder.directory(new File("eye_tracker.py 경로")); -> 주석 처리 해제 시 eye_tracker.py가 속한 폴더에 log.csv 파일 생성
            process = builder.start();
            System.out.println("Process is started.");
        } catch (IOException e) {
            System.err.println("Failed to start process");
            e.printStackTrace();
        }
    }

    public static void end() {
        if (process == null || !process.isAlive()) {
            System.out.println("Process is not running");
            return;
        }

        process.destroy();
        System.out.println("process ended");
    }
}
