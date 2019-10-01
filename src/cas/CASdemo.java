package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dinghy
 * @date 2019/8/26 16:47
 */
public class CASdemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        int res = atomicInteger.getAndIncrement();
        System.out.println(res);
    }
}
