package deadlock;

/**
 * @author dinghy
 * @date 2019/9/25 13:52
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(() -> {
            myLock.testA();
        }).start();
        new Thread(() -> {
            myLock.testB();
        }).start();
    }

}

class MyLock {
    private Object lockA = new Object();
    private Object lockB = new Object();

    public void testA() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public void testB() {
        synchronized (lockB) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}