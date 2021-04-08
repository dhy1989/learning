package io.iostream;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author dinghy
 * @date 2021/4/7 16:21
 */
public class InputStreamTest {
    @Test
    public void testDataInputStream() throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("E:\\java.txt"));
        dos.writeUTF("α");
        dos.writeInt(1234567);
        dos.writeBoolean(true);
        dos.writeShort((short) 123);
        dos.writeLong((long) 456);
        dos.writeDouble(99.98);
        DataInputStream dis = new DataInputStream(new FileInputStream("E:\\java.txt"));
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readShort());
        System.out.println(dis.readLong());
        System.out.println(dis.readDouble());
        dis.close();
        dos.close();
    }

    @Test
    public void testPrintWriter() throws Exception {
        PrintWriter printWriter = new PrintWriter("test.txt", StandardCharsets.UTF_8.displayName());
        printWriter.println(11111111);
        printWriter.write("你好");
        printWriter.write(",李焕英");
        printWriter.close();
    }

    @Test
    public void testZipInput() throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("E:\\springboot.zip"), StandardCharsets.UTF_8);
        ZipEntry zipEntry;
        byte[] buffer = new byte[1024];
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println(zipEntry.getName());
            int len = 0;
            while ((len = zipInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len, StandardCharsets.UTF_8.displayName()));
            }
        }
        zipInputStream.close();
    }

    @Test
    public void testZipOut() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\test.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream, StandardCharsets.UTF_8);
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        byte[] buffer = new byte[1024];
        int len=0;
        while((len=fileInputStream.read(buffer))!=-1){
            ZipEntry zipEntry = new ZipEntry("test.txt");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(buffer,0,len);
            zipOutputStream.closeEntry();
        }
        fileInputStream.close();
        zipOutputStream.close();
        fileOutputStream.close();
    }
}
