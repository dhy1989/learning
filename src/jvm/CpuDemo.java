package jvm;

import java.util.Random;

/**
 *@Description
    ##CPU过高问题定位
    1. top命令定位进程
    2. jps定位程序
    3. 定位到具体线程或代码
    ps -mp 进程 -o THREAD,tid,time
    参数解释
    -m 显示所有线程
    -p 使用cpu的进程
    -o 用户自定义格式
    4.将线程id转换为16进制格式(英文小写格式)  或者  printf "%x\n"有问题的线程id
    5.jstack 进程id |grep tid(16进制线程id小写英文) -A60(前60行)
 *@Author dinghy
 *@Date 2019/11/7 22:37
 */
public class CpuDemo {
    public static void main(String[] args) {
        while (true){
            System.out.println(new Random().nextInt(1000000));
        }
    }
}
