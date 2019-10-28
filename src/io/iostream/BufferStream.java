package io.iostream;

import java.io.*;

/**
 * @author dinghy
 * @date 2019/10/28
 */
public class BufferStream {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("doc/README.md"));
            bufferedWriter = new BufferedWriter(new FileWriter("doc/copy.md"));
            int count = 0;
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                System.out.println(s);
                count++;
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
