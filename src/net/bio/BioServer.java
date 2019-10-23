package net.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dinghy
 * @date 2019/10/22
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            new Thread(new Handler(socket)).start();
        }

    }
}

class Handler implements Runnable{
     private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader=null;
        PrintWriter writer=null;
        try {
            reader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            writer=new PrintWriter(socket.getOutputStream());
            String message;
            while((message=reader.readLine())!=null){
                System.out.println(message);
                writer.println("server socket receive message :" +message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer!=null){
                writer.close();
            }
        }
    }
}