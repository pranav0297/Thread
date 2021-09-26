import java.util.concurrent.*;
import java.util.*;
public class java_7{

    public java_7(){
        class MyCallable implements Callable<Integer>{
            Integer id = 1;
            public MyCallable(Integer val){
                this.id = val;
            }
            public Integer call(){
                return id;
            }
        }
        System.out.println("creating List");
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<MyCallable> futureList = new ArrayList<MyCallable>();
        for (int i = 0; i < 10; i++){
            MyCallable myCallable = new MyCallable((Integer)i);
            futureList.add(myCallable);
        }
        System.out.println("Processing Start");
        try{
            List<Future<Integer>> futures = service.invokeAll(futureList);
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Processing Completed");
        service.shutdown();
    }

    public static void main(String args[]){
        java_7 demo = new java_7();
    }
}
