import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadRunner {
    public static final long MAX_VALUE = 10000000000L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                execute(MAX_VALUE);
            }
        });
        thread1.start();

        //execute(MAX_VALUE);


        //stworycć 5 callablle/runnable i odpalić Executorem  1/5Max_value
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = new ArrayList<>();

        for(int i =0; i<5;i++){
            tasks.add(new Callable<String>(){
                @Override
                public String call(){
                    for (long l = 0; 1<MAX_VALUE/5;l++);
                }
            });

        }
        long startTime = System.nanoTime();
        List<Future<String>> futures = executorService.invokeAll(tasks);
        for(Future<String> result : futures)result.get();
        long endTime = System.nanoTime();
        System.out.println(Thread.currentThread().getName()+ " " + (double) (endTime - startTime) / 100000000);
        executorService.shutdown();

    }

    private static void execute(long value) {
        long startTime = System.nanoTime();
        for (long l = 0; l < MAX_VALUE; l++) ;
        long endTime = System.nanoTime();
        System.out.println(Thread.currentThread().getName()+" "+(double) (endTime - startTime) / 100000000);
        //executorService.shutdown();
    }
}
