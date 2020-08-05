package juc.queue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author dinghy
 * @date 2020/8/5 09:01
 */
public class QueueDemoTest {
    /**
     * @Description
     * {@linkplain  ArrayBlockingQueue}
     * add() 如果Queue空间满了抛出java.lang.IllegalStateException: Queue full
     * put() 如果Queue空间满了,会一直等待Queue里边数据消费
     * offer() 如果Queue空间满了,直接返回false
     * take() 如果Queue没数据了,会wait
     * poll() 没数据了直接返回null,如果使用while循环,不能使用poll(),会导致cpu100%
     * peek() 查询头部数据
     * @Author dinghy
     * @Date 2020/8/5 9:10
     */
    @Test
    public  void  testArrayQueue() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);
        blockingQueue.put(5);
        blockingQueue.offer(6);
        System.out.println(blockingQueue);
        for (;;){
            if( blockingQueue.isEmpty()){
                break;
            }
            Integer take = blockingQueue.take();
            System.out.println("take-->"+take);
            Integer peek = blockingQueue.peek();
            System.out.println("peek-->"+peek);
        }
        blockingQueue.put(6);
        Integer take = blockingQueue.take();
        System.out.println("take-->"+take);
    }
}
