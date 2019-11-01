package jvm;

 /**
  * @Author dinghy
  * @Date 2019/11/1 14:49
  * @Description  -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/
  */
public class OutOfMemoryDermo {
    public static void main(String[] args) {
        while (true){
            byte[] bytes=new byte[1024*1024];
            System.out.println(bytes);
        }
    }
}
