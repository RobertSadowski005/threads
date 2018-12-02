public class StopRequested {
    private static boolean stopRequested = false;
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            //    System.out.println("zaczyna się T");
                int i = 0;
                while (!stopRequested){
                    i++;
                    //System.out.println(i);
                }
          //      System.out.println("Kończy się T");
            }
        });
        t.start();
        //System.out.println("Zaczyna się główny");
        Thread.sleep(1000);
        stopRequested = true;
        //System.out.println("Kończy się głowny");
    }
}
