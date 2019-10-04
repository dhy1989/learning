package juc.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dinghy
 * @date 2019/10/3 15:31
 */
public class ProducerConsumerTwo {
    public static void main(String[] args) {
        TwoCondition condition = new TwoCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.increment();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.decrement();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.decrement();
            }
        }, "D").start();
    }
}

class TwoCondition {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "----" + number);
            number++;
          condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "----" + number);
            number--;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}