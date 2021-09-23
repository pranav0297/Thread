import java.util.concurrent.*;

 class Scheduled_8_3 extends Thread {
    private String clockName;

    public Scheduled_8_3(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 5; i >= 0; i--) {

            System.out.println(Thread.currentThread().getName()+"==running with fixed delay");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        Scheduled_8_3 clock1 = new Scheduled_8_3("A");
        Scheduled_8_3 clock2 = new Scheduled_8_3("B");
        Scheduled_8_3 clock3 = new Scheduled_8_3("C");

        scheduler.scheduleWithFixedDelay(clock1, 3, 10, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock2, 3, 15, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock3, 3, 20, TimeUnit.SECONDS);

    }
}

