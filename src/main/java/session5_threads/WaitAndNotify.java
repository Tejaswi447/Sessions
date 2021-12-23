
package session5_threads;

public class WaitAndNotify {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b){
            try{
                System.out.println("Waiting for second thread to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Total is: " + b.total);
        }


    ThreadB b1 = new ThreadB();
        b1.start();

    synchronized(b1){
       try{
            System.out.println("Waiting for second thread to complete...");
            b1.wait();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Total is: " + b1.total);
    }

}
}
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
        }
    }
}
