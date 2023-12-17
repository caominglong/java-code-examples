package com.banmao.network.netty_.bio_;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/13 下午10:44
 * @description
 */
public class BIOServer {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        // 1、创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(8089);
        System.out.println("服务器启动了");
        // 2、监听某个端口
        while(true) {
            // 监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //
            // 3、如果有客户端连接了，就创建一个线程，与之通信（单独写一个方法）
            executorService.execute(() -> {
                // 可以和客户端通信的
                handler(socket);
            });
        }
    }

    public static void handler(Socket socket) {
        System.out.println("线程信息id=" + Thread.currentThread().getId() + "线程名字=" + Thread.currentThread().getName());
        try {
            byte[] bytes = new byte[1024];
            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            int readLength = 0;
            // 读取客户端发送的数据
            while ((readLength = inputStream.read(bytes)) != -1) {
                System.out.println("线程信息id=" + Thread.currentThread().getId() + "线程名字=" + Thread.currentThread().getName());
                System.out.println(new String(bytes, 0, readLength));
            }
        } catch (Exception e) {

        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}