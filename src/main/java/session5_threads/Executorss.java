
package session5_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Executorss {
    public static void main(String[] args) {
        //creating a pool of 5 threads  
        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {  
            Runnable worker = new WorkerThread("I'm thread " + i);  
            //calling execute method of ExecutorService
            executor.execute(worker);  
          }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
  
        System.out.println("Finished all threads");  
    }


    public static class WorkerThread implements Runnable{
        private final String message;
        //Constructor to assign a message when creating a new thread
        public WorkerThread(String message){
            this.message=message;
        }

       public void run() {
            System.out.println(Thread.currentThread().getName()+
                    " (Start) message = " + message);
            //call workToBeDone method to simulate a delay
            workToBeDone();
            System.out.println(Thread.currentThread().getName()+
                    " (End)");//prints thread name
        }
        private void workToBeDone() {
            try {  Thread.sleep(2000);  }
            catch (InterruptedException e)
            { e.printStackTrace(); }
        }
    }
}
