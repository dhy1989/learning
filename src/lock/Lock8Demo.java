package lock;


import java.util.concurrent.TimeUnit;

/**
 * @author dinghy
 * @date 2019/10/3 07:44
 * <p>
 * 请问打印结果
 * 1.标准访问,请问是先发送邮件还是发送短信
 * 2.暂停4秒钟发送邮件方法,请问是先发送邮件还是发送短信
 * 3.新增普通sayHello方法,请问是先发送邮件还是sayHello
 * 4.2部手机,请问是先发送邮件还是发送短信
 * 5.2个静态同步方法,同一部手机,请问是先发送邮件,还是先发送短信
 * 6.2个静态同步方法,2部手机,请问是先发送邮件,还是发送短信
 * 7.1个静态同步方法,1个普通同步方法,同一部手机,请问是先发送邮件,还是发送短信
 * 8.1个静态同步方法,1个普通同步方法,2部手机,请问是先发送邮件,还是发送短信
 * <p>
 * Java中每个对象都可以作为锁,具体表现:
 * (1)对于普通的同步方法,锁住的是当前的对象this
 * (2)对于同步方法,锁住的是synchronized括号里边的对象
 * (3)对于静态同步方法,锁是当前类的Class对象
 * </p>
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> phone.sendEmail()).start();
        new Thread(() -> phone.sendSMS()).start();
        //  new Thread(() -> phone.sayHello()).start();
    }
}

class Phone {
    public synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("sendSms");
    }

    public void sayHello() {
        System.out.println("sayHello");
    }

}
