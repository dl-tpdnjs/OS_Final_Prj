import java.io.File;
import java.io.IOException;

public class ActivatePy {

    private static Process process;

    public static void start() {
        try {
            String virtualPath = "가상 환경 경로/python.exe"; //가상 환경 경로 설정
            ProcessBuilder builder = new ProcessBuilder(virtualPath, "eye_tracker.py 경로"); //eye_tracker.py 경로 설정
            //builder.directory(new File("C:/python/pythonProject/adhd"));
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
