import java.lang.Object;
public class waitnotify_13 {
    private Object lock = new Object();
    public static void main (String args[]){
        waitnotify_13 thread =  new waitnotify_13();
       new Thread(()->{
           try {
               synchronized (thread.lock) {
                   System.out.println("thread 1");
                   Thread.sleep(500);
                   thread.lock.wait();
                   System.out.println("back to thread 1  after completion thread 2");

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
                    thread.lock.notify();
                    System.out.println("thread 2 still active after nofify call beacuse first it complete the remaining executation");
                    System.out.println("thread 2 active");
                    System.out.println("thread 2 active");
                    System.out.println("thread 2 active");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}
