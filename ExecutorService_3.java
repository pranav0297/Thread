import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService_3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5 ; i++) {
            executorService.submit(() -> {
                System.out.println( Thread.currentThread().getName()+" ==Doing through executor");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();

    }
}


