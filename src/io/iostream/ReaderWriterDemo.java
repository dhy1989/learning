package io.iostream;

import java.io.*;

/**
 * @author dinghy
 * @date 2019/10/27
 */
public class ReaderWriterDemo {
    public static void main(String[] args) {
        File file = new File("doc/README.md");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(new File("doc/copy.md"));
            char[] chars = new char[1024];
            int len;
            while ((len = fileReader.read(chars, 0, chars.length)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
                fileWriter.write(chars,0,len);
                fileWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
