package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dinghy
 * @date 2019/10/4 10:47
 * <p>
 *     有返回值得实现了{@link java.util.concurrent.Callable}
 *     FutureTask构造里边传入Callable实现类
 * </p>
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
            return 1;
        });
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
