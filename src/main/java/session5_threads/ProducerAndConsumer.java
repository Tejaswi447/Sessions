package session5_threads;

import com.sun.nio.sctp.SctpSocketOption;

class demo{
    int num;
    boolean valueSet=false;
    public synchronized void put(int num) {

            while (valueSet) {
                try {
                    wait();
                } catch (Exception e) {
                };
            }

            System.out.println("put:" + " " + num);
            this.num = num;
            valueSet = true;
            notify();
        }
    public synchronized void get(){
        while(!valueSet){
            try{wait();}catch (Exception e){};
        }
        System.out.println("get:"+" "+num);
        valueSet=false;
        notify();
    }
}

class producer implements Runnable{
demo d;
public producer(demo d){
    this.d=d;
    Thread t1=new Thread(this,"thread-1");
    t1.start();
}
    @Override
    public void run() {
    int i=0;
    while(i<=10){
        d.put(i++);
        try{Thread.sleep(1000);}catch (Exception e){};
    }
    }
}
class Consumer implements Runnable
{
    demo d;
    public Consumer(demo d){
        this.d=d;
        Thread t2=new Thread(this,"thread-2");
        t2.start();
    }
    public void run(){
        while(true){
            d.get();
            try{Thread.sleep(1000);}catch (Exception e){};
        }
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args) {
     demo d =new demo();
        new producer(d);

        new Consumer(d);
    }
}
