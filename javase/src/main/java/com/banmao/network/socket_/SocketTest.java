package com.banmao.network.socket_;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/13 下午8:03
 * @description socket编程
 */
public class SocketTest {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8089);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("您好".getBytes());
        //outputStream.close();
        // socket.close();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clientFromScanner() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8089);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            outputStream.write(next.getBytes());
        }
        System.out.println("退出了循环");
        outputStream.close();
        socket.close();
    }


    @Test
    public void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("#")) {
            System.out.println("键盘输入的内容是：" + scanner.next());
        }
        System.out.println("退出循环。。。");
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8089));
        System.out.println("server在8089监听");
        Socket socket = serverSocket.accept();
        System.out.println(Thread.currentThread().getName());
        System.out.println("有客户端连接上来");
        InputStream inputStream = socket.getInputStream();
        int readLength = 0;
        byte[] bytes = new byte[1024];
        while ((readLength = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLength));
        }
        System.out.println("数据读完了");
    }
}