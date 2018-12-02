import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExecutor implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Hello thread!");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello main thread!");

        //runSingleThread();
        runMultipleThreads();
    }

    private static void runMultipleThreads() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) tasks.add(new CallableExecutor());

        List<Future<String>> threadResults = executorService.invokeAll(tasks);

        Thread.sleep(1000);

        for (Future<String> threadResult : threadResults) {
            System.out.println(threadResult.get());
        }
        executorService.shutdown();


    }

    private static void runSingleThread() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> threadResult = executorService.submit(new CallableExecutor());

        System.out.println("Wynik: " + threadResult.get());
        executorService.shutdown();
    }

}
