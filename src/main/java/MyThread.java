public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello I'm thread!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        //Thread.sleep(100);
        System.out.println("Hello World!");
    }
}