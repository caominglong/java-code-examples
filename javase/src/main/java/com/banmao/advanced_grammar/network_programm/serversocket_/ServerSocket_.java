package com.banmao.advanced_grammar.network_programm.serversocket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 上午11:04
 * @description socket服务器端
 */
public class ServerSocket_ {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        // 接收一个请求，如果没有客户端连接端时候，程序会阻塞，等待连接
        Socket accept = serverSocket.accept();
        // 往客户端写数据
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write('A');
        // 关闭socket
        outputStream.close();
        accept.close();
        serverSocket.close();
    }
}