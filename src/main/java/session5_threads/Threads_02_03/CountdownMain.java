//synchronised block
package session5_threads.Threads_02_03;

public class CountdownMain {
    public static void main(String[] args) {
        Countdown CD = new Countdown();
        Runnable r = () -> {
        synchronized (CD){
         CD.printCount();
        }
    };
        Thread one = new Thread(r,"one");
        Thread two = new Thread(r,"two");
        one.start();
        two.start();
    }

    public static class Countdown {
        public void printCount() {
          try {
             for(int i = 10; i > 0; i--) {
                System.out.println("  ---   "  + i );
             }
             System.out.println("BlastOff!");
          }catch (Exception e) {
             System.out.println("Thread  interrupted.");
          }
       }
    }
}

