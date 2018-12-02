public class RunnableLambda {

    public static void main(String[] args) {
        System.out.println("Hello main thread");
        Runnable myRunnable = () -> {
            System.out.println("Hello Thread");
            Thread currentThread = Thread.currentThread();
            System.out.println("Nazwa wątku " + currentThread.getName());
        };

        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("Wątek główny " + mainThread.getName());
    }

}
