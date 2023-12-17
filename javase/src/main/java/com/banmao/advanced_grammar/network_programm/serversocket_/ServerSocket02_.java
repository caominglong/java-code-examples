package com.banmao.advanced_grammar.network_programm.serversocket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:04
 * @description socket服务器端
 */
public class ServerSocket02_ {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 重要：这里客户端接收不到服务端发送的消息，待排查
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，服务端在9999端口监听...");
        // 接收一个请求，如果没有客户端连接的时候，程序会阻塞，等待连接
        Socket accept = serverSocket.accept();
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，服务端收到客户端的连接，连接地址为：" + accept.getRemoteSocketAddress());
        // 接收客户端的数据，hello server
        InputStream inputStream = accept.getInputStream();
        System.out.println(readMessage(inputStream));

        // accept.shutdownInput();
        // 往客户端写消息 hello client
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，服务端收到hello server后给客户端一个答复：hello client");
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hello client".getBytes());
        outputStream.flush();
        accept.shutdownOutput();

        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，服务端通话结束");

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
            String s = new String(buf, 0, readLength);
            String str = "服务端收到客户端发送的消息：" + s;
            builder.append(str);
        }
        return builder.toString();
    }
}