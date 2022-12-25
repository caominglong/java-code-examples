package com.banmao.advanced_grammar.network_programm.socketclient_;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:07
 * @description
 */
public class SocketClient02_ {

    public static void main(String[] args) throws IOException {
        // 1、连接服务端
        Socket socket = new Socket("192.168.0.102", 9999);
        // 2、往服务端发送hello server
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());
        // 将消息刷出去
        socket.shutdownOutput();
        // 发送完之后，接收服务端发送的hello client
        InputStream inputStream = socket.getInputStream();
        System.out.println(socket.isConnected());
        byte[] buf = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLength));
        }
        System.out.println("aaaaaaa");
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