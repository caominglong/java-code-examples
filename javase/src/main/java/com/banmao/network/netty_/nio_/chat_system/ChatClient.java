package com.banmao.network.netty_.nio_.chat_system;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/15 下午10:40
 * @description
 */
public class ChatClient {

    // 定义属性
    private Selector selector;
    private SocketChannel socketChannel;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6667;
    private String username;

    // 构造器
    public ChatClient() {
        System.out.println("构造器的线程为：" + Thread.currentThread().getName());
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            // 设置非阻塞模式
            socketChannel.configureBlocking(false);

            // 注册到Selector上
            socketChannel.register(selector, SelectionKey.OP_READ);

            username = socketChannel.getLocalAddress().toString().substring(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInfoToServer(String info) {
        info = username + "说：" + info;

        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取服务器端回复的消息

    }

    // 读取从服务端回复的消息
    public void readInfo() {
        try {
//            while (true) {
                // 如果不加2000，则select会阻塞在这里
                int select = selector.select();
                if (select > 0) {
                    // 有可用的通道
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        if (next.isReadable()) {
                            // 从SelectionKey中获取通道
                            SocketChannel channel = (SocketChannel) next.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            channel.read(byteBuffer);

                            // 翻转
                            byteBuffer.flip();

                            // 展示输出的消息
                            System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()).trim());
                        }
                        // 将当前的key移除掉,防止重复操作
                        iterator.remove();
                    }
                } else {
                    // System.out.println("没有监听到从服务端发送过来的消息");
                }
           // }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动我们的客户端
        ChatClient chatClient = new ChatClient();

        // 启动一个线程
        new Thread(() -> {
            while (true) {
                chatClient.readInfo();

                // 每隔3s读取数据
                Thread thread = Thread.currentThread();
                try {
                    thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("发送数据给服务端....");
        // 发送数据给服务端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.next();
            System.out.println("发过去了");
            chatClient.sendInfoToServer(str);
        }
    }

}