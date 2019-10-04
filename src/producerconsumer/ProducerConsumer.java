package producerconsumer;

/**
 * <p>
 * 题目:现在两个线程,可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1,一个线程对该变量减1
 * 实现交替,来10轮,变量初始值为0
 * <p>
 * 1.高内聚低耦合前提下,线程操作资源类
 * 2.判断/干活/通知
 * 3.防止虚假唤醒
 * </p>
 *
 * @author dinghy
 * @date 2019/10/3 14:18
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        MyCondition myCondition = new MyCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myCondition.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myCondition.decrement();
            }
        }, "B").start();

    }
}

class MyCondition {
    private int number = 0;

    public synchronized void increment() {
        // 判断
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 操作
        System.out.println(Thread.currentThread().getName() + "----------" + number);
        number++;
        // 通知
        this.notifyAll();
    }

    public synchronized void decrement() {
        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "-------" + number);
        number--;
        this.notifyAll();
    }
}