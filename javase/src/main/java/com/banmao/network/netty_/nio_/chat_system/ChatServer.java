package com.banmao.network.netty_.nio_.chat_system;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/15 下午10:40
 * @description
 */
public class ChatServer {

    // 定义属性
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int port = 6667;

    // 构造器
    public ChatServer() {
        System.out.println("构造器的线程为：" + Thread.currentThread().getName());
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));

            // 设置非阻塞模式
            serverSocketChannel.configureBlocking(false);

            // 注册到Selector上
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        // 循环处理
        try {
            while (true) {
                System.out.println("循环");
                int select = selector.select();

                if (select > 0) {
                    // 遍历得到的selectionKey
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        if (next.isAcceptable()) {
                            System.out.println("连接客户端的当前线程为：" + Thread.currentThread().getName());
                            // 接收到注册事件
                            // 创建一个客户端的SocketChannel
                            SocketChannel accept = serverSocketChannel.accept();

                            // 配置为非阻塞模式
                            accept.configureBlocking(false);

                            // 将该SocketChannel也注册到Selector上
                            accept.register(selector, SelectionKey.OP_READ);

                            System.out.println(accept.getRemoteAddress() + "上线");
                        } else if (next.isReadable()) {
                            //System.out.println(next.isReadable());
                            // 通道发生read事件，通道可读了
                            System.out.println("客户端发送消息的当前线程为：" + Thread.currentThread().getName());
    //                            try {
    //                                Thread.sleep(3000);
    //                            } catch (InterruptedException e) {
    //                                e.printStackTrace();
    //                            }
                            readData(next);
                        }
                        // 防止重复处理
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待客户端连接...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取客户端消息
    public void readData(SelectionKey key) {
        // 获取一个SocketChannel
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();

            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            System.out.println("count=" + count);

            if (count > 0) {
                // 翻转
                buffer.flip();
                String msg = new String(buffer.array(), 0, count);
                System.out.println(msg);

                // 向其它客户端转发消息
                sendInfoToOtherClients(msg, channel);
            }
//            if (count < 0) {
//                // 取消注册
//                key.cancel();
//                // 关闭通道
//                channel.close();
//            }


        } catch (Exception e) {
            try {
                System.out.println(channel.getRemoteAddress() + "离线了...");
                // 取消注册
                key.cancel();
                // 关闭通道
                channel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // 转发消息给其它客户（通道）
    public void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息");
        // 所有注册到selector上的SocketChannel,并排查self
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            // 通过key取出对应的SocketChannel
            Channel channel = key.channel();
            if (channel instanceof SocketChannel && channel != self) {
               //
                SocketChannel socketChannel = (SocketChannel) channel;

                // 将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

                // 将buffer写入通道
                socketChannel.write(buffer);
            }
        }

    }

    public static void main(String[] args) {
        // 启动服务器端
        ChatServer chatServer = new ChatServer();
        chatServer.listen();
    }
}