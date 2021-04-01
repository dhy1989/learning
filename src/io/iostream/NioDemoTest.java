package io.iostream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author dinghy
 * @date 2021/3/31 18:18
 */
public class NioDemoTest {
    @Test
    public void testFileChannelRead() throws IOException {
        FileChannel fileChannel = FileChannel.open(Paths.get("doc/README.md"), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        int read = fileChannel.read(byteBuffer);
        while (read != -1) {
            System.out.println("read--->" + read);
            byteBuffer.flip();
            byte[] array = byteBuffer.array();
            System.out.println(new String(array, StandardCharsets.UTF_8));
            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
    }

    /**
     * @description position表示读取或者写入的初始位置
     * limit表示在写入或者读取的时候,最大的限制
     * capacity表示buffer的最大容量
     * @author dinghy
     * @date 2021/4/1 11:23
     */
    @Test
    public void testBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        System.out.println("mark-->" + byteBuffer.mark());
        byte a = 1;
        byteBuffer.put(a);
        byteBuffer.put(a);
        byteBuffer.put(a);
        byteBuffer.put(a);
        System.out.println("---------------------");
        System.out.println("mark-->" + byteBuffer.mark());
        // 如果需要读取需要转换成读取的模式
        byteBuffer.flip();
        System.out.println("---------------------");
        System.out.println("mark-->" + byteBuffer.mark());
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            System.out.println(b);
        }
        System.out.println("---------------------");
        System.out.println("mark-->" + byteBuffer.mark());
    }

    @Test
    public void copyFile() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("pom.xml"));
        FileOutputStream outputStream = new FileOutputStream("pom1.xml");
        FileChannel out = outputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(100);
        int read = in.read(byteBuffer);
        while (read>0){
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
            read = in.read(byteBuffer);
        }
        in.close();
        out.close();
        outputStream.close();
    }

    @Test
    public void testTransferTo() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("pom.xml"));
        FileOutputStream outputStream = new FileOutputStream("pom1.xml");
        FileChannel out = outputStream.getChannel();
        in.transferTo(in.position(),in.size(),out);
        in.close();
        out.close();
        outputStream.close();
    }

    @Test
    public void testTransferFrom() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("pom.xml"));
        FileOutputStream outputStream = new FileOutputStream("pom1.xml");
        FileChannel out = outputStream.getChannel();
        out.transferFrom(in,in.position(),in.size());
        in.close();
        out.close();
        outputStream.close();
    }
}
