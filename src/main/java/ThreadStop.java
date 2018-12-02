public class ThreadStop {
        public static void main(String[] args) throws Exception {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (true){
                        i++;
                        System.out.println(i);
                    }

                }
            });
            t.start();
            Thread.sleep(1000);
            t.stop();
        }
}
