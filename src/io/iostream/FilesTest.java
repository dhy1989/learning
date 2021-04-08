package io.iostream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author dinghy
 * @date 2021/3/31 18:12
 */
public class FilesTest {
    @Test
    public void test() throws IOException {
        Files.lines(Paths.get("doc/README.md"), StandardCharsets.UTF_8).forEach(x -> System.out.println(x));
    }

    @Test
    public void testPath() throws IOException {
        // doc是文件夹
        Path doc = Paths.get("doc");
        // 获取文件夹下边的文件
        Stream<Path> list = Files.list(doc);
        list.forEach(x->{
            try {
                Files.lines(x,StandardCharsets.UTF_8).forEach(line-> System.out.println(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
