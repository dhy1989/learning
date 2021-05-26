package threadpool;


import java.util.concurrent.*;

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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,8,10 ,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10),new MyHandler());
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
    private String name="致命任务";
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}

class MyHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.getClass());
        if(r instanceof Work){
            Work r1 = (Work) r;
            System.out.println(r1.getName());
        }
        System.out.println(executor.getTaskCount());
    }
}