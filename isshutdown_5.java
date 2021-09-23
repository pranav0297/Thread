import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class isshutdown_5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5 ; i++) {
            executorService.submit(() -> {
                System.out.println( Thread.currentThread().getName()+" ==Doing through executor");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //executorService.shutdownNow();
        executorService.shutdown();
        System.out.println(" Is Executor Service is shutdown :"+ executorService.isShutdown());
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Treminated");
            System.out.println(" Is Executor Service is Terminated :"+ executorService.isTerminated());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


