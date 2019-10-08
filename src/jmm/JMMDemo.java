package jmm;

import java.util.concurrent.TimeUnit;

/**
 * @author dinghy
 * @date 2019/10/8 17:57
 * <p>
 *     当{@link MyData}类的number 没有被volatile修饰时候,不会执行到最后一行代码
 *     每个线程都拷贝一份变量副本,没有volatile修饰时候main线程不知道数据已经被修改
 * </p>
 */
public class JMMDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"--come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.changeNumber(1024);
                System.out.println(Thread.currentThread().getName()+"--- number=="+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ,"A").start();
        while (myData.number==100){

        }
        System.out.println(Thread.currentThread().getName()+"---over");
    }
}

class MyData {
  volatile   int number = 100;

    public void changeNumber(int number) {
        this.number = number;
    }
}