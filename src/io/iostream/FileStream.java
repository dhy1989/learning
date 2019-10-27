package io.iostream;

import java.io.*;

/**
 * <p>
 *     关于关闭流的顺序，先关外层，再关内层，类比：假设某地着火，消防灭火后，
 *     是先关消防水龙头，还是关自来水厂
 * </p>
 * @author dinghy
 * @date 2019/10/27
 */
public class FileStream {
    public static void main(String[] args) {
        File file = new File("doc/README.md");
        FileInputStream fis = null;
        FileOutputStream fos=null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(new File("doc/copy.md"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len, "UTF-8");
                System.out.println(s);
                fos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
