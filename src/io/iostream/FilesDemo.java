package io.iostream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author dinghy
 * @date 2021/3/31 18:12
 */
public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("doc/README.md"), StandardCharsets.UTF_8).forEach(x-> System.out.println(x));
    }
}
