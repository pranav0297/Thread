import java.util.concurrent.*;

public class Schedule_8_2 implements Runnable {

    public void run() {
        System.out.println("Scheduler run after fixed rate");
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();


        Runnable task = new Schedule_8_2();
        int initialDelay = 4;
        int periodicDelay = 2;

        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
                TimeUnit.SECONDS);
    }
}
