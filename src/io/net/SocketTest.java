package io.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author dinghy
 * @date 2021/4/9 17:27
 */
public class SocketTest {
    @Test
    public void test() throws UnknownHostException {
        InetAddress[] inetAddress = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress address : inetAddress) {
            System.out.println(address);
        }
    }

    @Test
    public void testTelnet() throws IOException {
        // telnet 127.0.0.1 8189
        ServerSocket serverSocket = new ServerSocket(8189);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        Scanner in=new Scanner(inputStream, StandardCharsets.UTF_8.name());
        PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8.name()),true);
        printWriter.println("Hello! enter BYE to exit");
        boolean done=false;
        while (!done&&in.hasNextLine()){
            String line=in.nextLine();
            printWriter.println("echo:"+line);
            if(line.trim().equals("BYE")){
                done=true;
                accept.close();
            }
        }

    }
}
