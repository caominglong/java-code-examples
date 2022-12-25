package com.banmao.advanced_grammar.network_programm.serversocket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:04
 * @description socket服务器端
 */
public class ServerSocket02_ {

    // 重要：这里客户端接收不到服务端发送的消息，待排查
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听...");
        // 接收一个请求，如果没有客户端连接端时候，程序会阻塞，等待连接
        Socket accept = serverSocket.accept();
        // 接收客户端的数据，hello server
        InputStream inputStream = accept.getInputStream();
        System.out.println(readMessage(inputStream));

        accept.shutdownInput();
        System.out.println(accept.isConnected());
        // 往客户端写消息 hello client
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hello client".getBytes());
        outputStream.flush();
        accept.shutdownOutput();


        // 关闭socket
        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }

    public static String readMessage(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        byte[] buf = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(buf)) != -1) {
            builder.append(new String(buf, 0, readLength));
        }
        return builder.toString();
    }
}