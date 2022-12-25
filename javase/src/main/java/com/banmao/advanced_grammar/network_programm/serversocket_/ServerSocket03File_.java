package com.banmao.advanced_grammar.network_programm.serversocket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:04
 * @description socket服务器端
 */
public class ServerSocket03File_ {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听...");
        // 接收一个请求，如果没有客户端连接端时候，程序会阻塞，等待连接
        Socket accept = serverSocket.accept();
        // 接收到客户端发送的图片,保存到src下
        InputStream inputStream = accept.getInputStream();
        saveImgToDestPath(readFileFromSocket(inputStream), "/Users/cao/Desktop/mulu/socket/杭州书屋.jpg");

        System.out.println("成功写入文件到磁盘");
        // 通知客户端，"收到图片"
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("收到图片".getBytes());
        accept.shutdownOutput();
        // 关闭socket
        inputStream.close();
        outputStream.close();
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

    public static byte[] readFileFromSocket(InputStream inputStream) throws IOException {
        byte[] allByte = null;
        int readLen = 0;
        byte[] bytes = new byte[1024];
        while ((readLen = inputStream.read(bytes)) != -1) {
            int orgLength = 0;
            int newLength = 0;
            if (allByte == null) {
                orgLength = 0;
                newLength = readLen;
                allByte = new byte[readLen];
            } else {
                orgLength = allByte.length;
                newLength = orgLength + readLen;
                allByte = Arrays.copyOf(allByte, newLength);
            }
            for (int i = orgLength; i < newLength; i++) {
                allByte[i] = bytes[i-orgLength];
            }
        }
        return allByte;
    }

    public static void saveImgToDestPath(byte[] bytes, String destPath) throws IOException {
        FileOutputStream fos = new FileOutputStream(destPath);
        fos.write(bytes);
        fos.close();
    }
}