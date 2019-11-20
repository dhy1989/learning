package juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 *     {@link ArrayBlockingQueue}
 *     add() 如果队列满了会抛异常  remove()如果队列里边没有元素会抛异常
 *
 * </p>
 *
 * @author dinghy
 * @date 2019/10/12 08:46
 */
public class ArryBlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue(3);
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
    }
}
