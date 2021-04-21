package net;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author dinghy
 * @date 2021/4/21 15:28
 */
public class UrlConnectionTest {
    @Test
    public void test() throws IOException {
        String baidu="http://www.baidu.com";
        URL url=new URL(baidu);
        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
        httpURLConnection.connect();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        headerFields.forEach((key,value)->{
            System.out.println(key);
            value.forEach(x->{
                System.out.println(x);
            });
            System.out.println("-------------------------");
        });
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str=bufferedReader.readLine())!=null){
            stringBuilder.append(str);
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
