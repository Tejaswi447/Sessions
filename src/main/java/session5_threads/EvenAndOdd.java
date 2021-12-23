package session5_threads;

public class EvenAndOdd {
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                        Thread.sleep(1000);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                        Thread.sleep(1000);

                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        };
        Thread t1 = new Thread(r1, "thread-1");
        Thread t2 = new Thread(r2, "thread-2");
        t1.start();
       try{ Thread.sleep(10);}catch (Exception e){}
        //t1.join();
        t2.start();

    }
}
