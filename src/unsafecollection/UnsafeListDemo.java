package unsafecollection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 * 1. java.util.ConcurrentModificationException 不完全集合并发异常
 * 2. 实现集合安全:
 * 1){@link java.util.Vector} 古老的实现类,使用synchronized,安全但是效率低下
 * 2)Collections.synchronizedList(List<T> list)
 * 3){@link CopyOnWriteArrayList} java.util.concurrent包下jdk1.5之后,最佳实现安全集合的方案
 * </p>
 *
 * @author dinghy
 * @date 2019/10/2 17:19
 */
public class UnsafeListDemo {
    public static void main(String[] args) {
        // List<String> list=new ArrayList<>();
        // List<String> list=new Vector<>();
        // List<String> list= Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
