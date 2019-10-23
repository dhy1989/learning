package jvm;

/**
 * @author dinghy
 * @date 2019/10/11 08:49
 */
public class GCDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Byte[] bytes=new Byte[2*1024*1024];
        }
    }
}
