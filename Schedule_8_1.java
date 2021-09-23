import java.util.concurrent.*;

public class Schedule_8_1 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Scheduler Execute after Seconds");
            }
        };
        int delay = 2;
        scheduler.schedule(task, delay, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
