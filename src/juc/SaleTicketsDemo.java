package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author dinghy
 * @date 2019/10/2 07:35
 * <ul>
 *     <li>{@link Thread.State} 线程的五个状态</li>
 *     <li>多线程三要素:线程 操作 资源类</li>
 * </ul>
 *
 */
public class SaleTicketsDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"C").start();
    }
}

class Ticket{
    private int tickets=30;
    private Lock lock=new ReentrantLock();
    public void saleTicket(){
        lock.lock();
        try {
            if(tickets>0){
                Thread.sleep(100);
                tickets--;
                System.out.println(Thread.currentThread().getName()+"--------剩余票数:"+tickets);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}