
public  class SynchronizedBlock_11 {
    private int n = 10;
    private  void increment() {
        this.n++;
    }
    private  void decrement() {
        this.n--;
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlock_11 sync = new SynchronizedBlock_11();
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 800; i++) {
                synchronized (o) {
                    sync.increment();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 800; i++) {
                synchronized (o) {
                    sync.decrement();
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println(sync.n);
    }
}
