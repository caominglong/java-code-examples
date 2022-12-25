package com.banmao.advanced_grammar.network_programm.socketclient_;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:07
 * @description
 */
public class SocketClient03File_ {

    public static void main(String[] args) throws IOException {
        // 1、连接服务端
        Socket socket = new Socket("127.0.0.1", 9999);
        // 2、往服务端发送图片
        byte[] bytes = readFileFromDisk("/Users/cao/Desktop/mulu/杭州书屋.jpg");
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput();
        System.out.println("发送图片给服务端：" + "/Users/cao/Desktop/mulu/杭州书屋.jpg");
        // 收到服务器返回的"收到图片"
        InputStream inputStream = socket.getInputStream();
        byte[] bytes1 = new byte[100];
        int byt = 0;
        int i = 0;
        while ((byt = inputStream.read()) != -1) {
            if (i >= bytes1.length) {
                bytes1 = Arrays.copyOf(bytes1, bytes1.length + 100);
            }
            bytes1[i] = (byte) byt;
            i++;
        }
        System.out.println(new String(bytes1, 0, i));
        // 3、关闭流
        bos.close();
        inputStream.close();
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

    public static byte[] readFileFromDisk(String filePath) throws IOException {
        byte[] allByte = null;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int readLen = 0;
        byte[] bytes = new byte[1024];
        while ((readLen = fileInputStream.read(bytes)) != -1) {
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
}