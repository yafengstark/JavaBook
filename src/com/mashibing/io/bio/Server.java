package com.mashibing.io.bio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一客户端一个连接
 *
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
        while(true) {
            Socket s = serverSocket.accept(); //阻塞方法

            new Thread(() -> {
                handle(s);
            }).start();
        }

    }

    static void handle(Socket s) {
        try {
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);// 没有数据发过来，也会阻塞
            System.out.println(new String(bytes, 0, len));

            s.getOutputStream().write(bytes, 0, len); // 对方没有接受，也会阻塞
            s.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
