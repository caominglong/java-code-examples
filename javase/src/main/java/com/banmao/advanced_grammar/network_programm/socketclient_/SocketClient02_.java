package com.banmao.advanced_grammar.network_programm.socketclient_;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:07
 * @description
 */
public class SocketClient02_ {

    private static DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws IOException {
        // 1、连接服务端
        Socket socket = new Socket("127.0.0.1", 9999);
        // 2、往服务端发送hello server
        OutputStream outputStream = socket.getOutputStream();
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
                "，连接成功，客户端往服务端发送消息：hello server");
        outputStream.write("hello server".getBytes());
        // 将消息刷出去，关闭此输出流，导致对方通讯结束
        socket.shutdownOutput();
        // 发送完之后，接收服务端发送的hello client
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(buf)) != -1) {
            System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
                    "，客户端收到服务端发送的消息：" + new String(buf, 0, readLength));
        }
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，客户端通话结束");
        // 3、关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
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