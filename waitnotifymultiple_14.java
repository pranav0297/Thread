import java.lang.Object;
public class waitnotifymultiple_14 {
    private Object lock = new Object();
    public static void main (String args[]){
        waitnotifymultiple_14 thread =  new waitnotifymultiple_14();
        new Thread(()->{
            try {
                synchronized (thread.lock) {
                    System.out.println("thread 1");
                    Thread.sleep(500);
                    thread.lock.wait();
                    thread.lock.notifyAll();

                    System.out.println("back to thread 1 ");

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                synchronized (thread.lock) {
                    System.out.println("thread 2");
                    Thread.sleep(500);
                    System.out.println("thread 2 still active after nofify call beacuse first it complete the remaining executation");
                    System.out.println("thread 2 active");
                    thread.lock.wait();
                    System.out.println("thread 2 back");
                    System.out.println("thread 2 back");
                }
           }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                synchronized (thread.lock) {
                    System.out.println("thread 3");
                    Thread.sleep(500);
                    System.out.println("thread 3 still active after nofify call beacuse first it complete the remaining executation");
                    System.out.println("thread 3 active");
                    System.out.println("thread 3 active");
                    thread.lock.wait();
                    System.out.println("thread 3 back");
                }
           }catch (InterruptedException e){
               // e.printStackTrace();
           }
        }).start();

        new Thread(()->{
            try {
                synchronized (thread.lock) {
                    System.out.println("thread 4");
                    Thread.sleep(500);
                    thread.lock.notifyAll();
                    System.out.println("thread 4 still active");
                    System.out.println("thread 4 active");
                    System.out.println("thread 4 active");
                    thread.lock.wait();
                    System.out.println("thread 4 back");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}

