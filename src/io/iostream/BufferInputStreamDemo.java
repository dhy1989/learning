package io.iostream;

import java.io.*;

/**
 * @author dinghy
 * @date 2019/10/29
 */
public class BufferInputStreamDemo {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream=null ;
        BufferedOutputStream bufferedOutputStream =null;
        try {
             bufferedInputStream = new BufferedInputStream(new FileInputStream("doc/README.md"));
             bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("doc/copy.md"));
            byte[] bytes=new byte[1024];
             int len;
             while ((len=bufferedInputStream.read(bytes))!=-1){
                 String s = new String(bytes, 0, len);
                 System.out.println(s);
                 bufferedOutputStream.write(bytes,0,len);
                 bufferedOutputStream.flush();
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
