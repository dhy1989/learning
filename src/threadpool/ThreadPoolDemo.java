package threadpool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dinghy
 * @date 2019/10/9 12:39
 *
 * <p>
 * {@linkplain ThreadPoolExecutor}
 * corePoolSize 闲置时候保持线程池的数量,类似银行人比较少时有10个柜台,但是只有3个柜台开放
 * maximumPoolSize 最大线程数量,类似银行人比较多时候,10个柜台全部开放
 *keepAliveTime 当线程数大于核心数时，这是多余的空闲线程在终止之前等待新任务的最长时间
 *
 * </p>
 */
public class ThreadPoolDemo{
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,8,10 ,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
        try {
            for (int i = 0; i < 25; i++) {
                System.out.println("workCount===>"+i);
                threadPoolExecutor.execute(new Work());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
class Work implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}