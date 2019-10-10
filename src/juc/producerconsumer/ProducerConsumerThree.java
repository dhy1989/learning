package juc.producerconsumer;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author dinghy
 * @date 2019/10/10 13:55
 */
public class ProducerConsumerThree {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
        new Thread(() ->
        {
            for (int i = 0; i < 30; i++) {
                try {
                    String str=UUID.randomUUID().toString().substring(0,5);
                    blockingQueue.put(str);
                    System.out.println(Thread.currentThread().getName()+"--"+str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
       ,"生产线程" ).start();

        new Thread(()->{
            while (true){
                Object take ;
                try {
                    TimeUnit.SECONDS.sleep(2);
                    take = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+"*****"+take.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"消费线程").start();
    }
}
