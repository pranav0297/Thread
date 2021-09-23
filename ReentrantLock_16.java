import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_16 {
    private static Integer integer =0;
    private static Integer integer2 =0;
    private static ReentrantLock lock1=new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private static Object lock = new Object();

    private static void increment (){
        lock1.lock();
        integer++;
        lock1.unlock();

    }
    private static void decrement(){
        lock2.lock();
        integer2--;
        lock2.unlock();
    }

    public static void main(String []args) throws InterruptedException{
        Thread t1 = new Thread(()->{
            for (int i =0;i<20000;i++){
                increment();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i =0;i<20000;i++){
                decrement();
            }
        });


        t1.start();
        t2.start();
        System.out.println("Final Value of Integer: " + integer);
        System.out.println("Final Value of Integer: " + integer2);

    }

}

