package com.banmao.advanced_grammar.network_programm.socketclient_;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:07
 * @description
 */
public class SocketClient_ {

    public static void main(String[] args) throws IOException {
        // 1、连接服务端
        Socket socket = new Socket("192.168.0.102", 9999);
        // 2、获取输入流,这里如果没有读入消息，也会阻塞在这里
        InputStream inputStream = socket.getInputStream();
        int byt = 0;
        while ((byt = inputStream.read())!= -1) {
            System.out.println((char) byt);
        }
        // 3、关闭流
        inputStream.close();
        socket.close();
    }
}