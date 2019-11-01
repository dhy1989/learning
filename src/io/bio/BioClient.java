package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author dinghy
 * @date 2019/10/22
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
        Scanner scanner = new Scanner(System.in);
        String message;
        while (true){
         message=scanner.nextLine();
         if(message.equals("exit")){
             break;
         }
         writer.println(message);
         writer.flush();
         System.out.println(bufferedReader.readLine());
        }


    }
}
