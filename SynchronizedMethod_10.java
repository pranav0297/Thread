
    public  class SynchronizedMethod_10 {
        private int n = 10;
        private synchronized void increment() {
            this.n++;
        }
        private synchronized void decrement() {
            this.n--;
        }
        public static void main(String[] args) throws InterruptedException {
            SynchronizedMethod_10 sync = new SynchronizedMethod_10();
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 800; i++) {
                    sync.increment();
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 800; i++) {
                    sync.decrement();
                }
            });
            t1.start();
            t2.start();
            System.out.println(sync.n);
        }
    }
