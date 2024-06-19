import java.io.IOException;

public class ActivatePy {

    private static Process process;

    public static void start() {
        try {
            ProcessBuilder builder = new ProcessBuilder("python", "C:/python/pythonProject/adhd/eye_tracker.py");
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