import java.util.concurrent.*;
public class java_9 extends Thread {
    private String clockName;

    public java_9(String clockName) {
        this.clockName = clockName;
    }
    public void run() {
        for (int i = 5; i >= 0; i--) {
            System.out.println(Thread.currentThread().getName()+"->"+ clockName+":"+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
          ExecutorService pool = Executors.newCachedThreadPool();                        //used for cached threadpool
        //ExecutorService pool = Executors.newFixedThreadPool(2);                       //used for Fixed threadpool
        pool.execute(new java_9("A"));
        pool.execute(new java_9("B"));
        pool.execute(new java_9("C"));
        pool.execute(new java_9("D"));
        pool.shutdown();
    }
}
