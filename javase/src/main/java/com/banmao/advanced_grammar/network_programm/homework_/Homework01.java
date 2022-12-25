package com.banmao.advanced_grammar.network_programm.homework_;

import com.sun.security.ntlm.Server;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午5:55
 * @description
 */
public class Homework01 {

    @Test
    public void tcpServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("在9999监听");
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if ("name".equals(message)) {
            bw.write("nova");
            bw.flush();
        } else if ("hobby".equals(message)) {
            bw.write("编写java程序");
            bw.flush();
        } else {
            bw.write("你说啥呢？");
            bw.flush();
        }

        // 关闭
        bw.close();
        br.close();
        serverSocket.close();
    }

    @Test
    public void tcpClient() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("name");
        bw.flush();
        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String name = br.readLine();
        System.out.println("name=" + name);

        // 发送hobby
        bw.write("hobby");
        bw.flush();

        String hobby = br.readLine();
        System.out.println("hobby=" + hobby);

        // 关闭
        br.close();
        bw.close();
        socket.close();
    }
}