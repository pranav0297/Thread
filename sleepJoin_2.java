public class sleepJoin_2 {
    public static void main(String args[]){
        Thread t1= new Thread (()->{
            try {
                System.out.println("active_Thread class ");
                Thread.sleep(5000);
                System.out.println("thread1 active  after sleep");
            }catch(InterruptedException e){
                e.printStackTrace();
           }
        });

        Thread t2=  new Thread (()->{
            System.out.println("active_Thread class 2 ");
          for(int i =0;i<5;i++) {
              System.out.println(i+" - t2");
          }
        });

      Thread t3 = new Thread (()->{
                System.out.println("active_Thread class 3 ");
          for(int i =0;i<5;i++) {
              System.out.println(i+" - t3");
          }
        });

        t1.start();
        try{
            t1.join();

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        t2.start();
        t3.start();


    }
}

