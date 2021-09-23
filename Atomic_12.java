class Atomic_12 extends Thread {
    private static Object c;
    int count = 0;

    public void run() {
        int max = 1;
        for (int i = 0; i < max; i++) {
            count++;
        }
    }

    public static class Counter {
        public static void main(String args[]) throws InterruptedException {

            Counter c = new Counter();

            Thread t1 = new Thread();
            Thread t2 = new Thread();
            Thread t3 = new Thread();
            Thread t4 = new Thread();

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();

            System.out.println(c.count);
        }
    }
}
