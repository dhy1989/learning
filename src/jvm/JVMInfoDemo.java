package jvm;

import java.util.UUID;

/**
 * @author dinghy
 * @date 2019/10/6 10:24
 * <p>
 *     jvm参数设置:
 *     打印GC信息:-XX:+PrintGCDetails
 *     初始堆大小:-Xms1024m 默认最大电脑的1/64
 *     最大堆大小:-Xmx1024m 默认电脑最大内存的1/4
 *     注意:生产环境下-Xms和-Xmx值大小一样
 * </p>
 *<p>
 *     常见异常:
 *     java.lang.OutOfMemoryError: Java heap space 对空间内存不够
 *</p>
 *
 */
public class JVMInfoDemo {
    public static void main(String[] args) {
        System.out.println("CPU的核数:"+Runtime.getRuntime().availableProcessors());
        System.out.println("-Xms:初始化JAVA虚拟机的总内存:"+Runtime.getRuntime().totalMemory()/1024/1024+"M");
        System.out.println("-Xmx:JAVA虚拟机可以使用的最大内存:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        StringBuilder str=new StringBuilder();
        while (true){
            str.append(UUID.randomUUID().toString()+"*****");
        }
    }
}
