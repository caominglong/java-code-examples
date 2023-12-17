package com.banmao.network.nio_.blocknio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/12 下午7:13
 * @description
 */
public class TestNoBlockingNio {

    private static DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void client() throws IOException {
        // 1、获取通道
        SocketChannel socketChannel =
                SocketChannel.open(new InetSocketAddress("127.0.0.1", 8089));

        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，客户端开始连接");

        // 2、设置非阻塞
        socketChannel.configureBlocking(false);

        // 3、获取指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4、发送数据给服务端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
                    "，从控制台获取输入的数据：输入数据为：" + next);
            if (next.equalsIgnoreCase("exit")) {
                // 5、关闭通道
                socketChannel.close();
            }
            buffer.put(next.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            // socketChannel.shutdownOutput();
            // scanner.remove();
        }

        // 5、关闭通道
        socketChannel.close();
    }


    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8089));

        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，服务端在8089端口监听");

        // 非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 4、创建一个选择器
        Selector selector = Selector.open();

        // 5、将通道注册到选择器中，且注册的是连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 6、轮训获取selector上已经就绪的事件
        while (true) {
            int select = selector.select();
            if (select > 0) {
                System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "，有事件就绪了");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                // System.out.println(selector.selectedKeys().size());
                while (iterator.hasNext()) {
                    // System.out.println("服务端一直在8089端口监听连接。。。");
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        // System.out.println(Thread.currentThread().getName());
                        // System.out.println("selector.select()=" + select);

                        // 获取连接的socketChannel
                        SocketChannel socketChannel = serverSocketChannel.accept();

                        // 有客户端连接上来了
                        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
                                "， 服务端收到客户端连接事件，连接地址为：" + socketChannel.getRemoteAddress());

                        // 配置通道为非阻塞模式
                        socketChannel.configureBlocking(false);
//
//                        // 将通道注册在选择器上，
//                        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
//                                "，客户端连接通道注册到选择器上，注册事件为可读事件：OP_READ");
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        // 有客户端连接上来了
                        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
                                "， 服务端收到客户端的数据可读事件");
                        // System.out.println("selector.select()=" + select);
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        // 获取指定大小的缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // 读取通道的数据
                        while (socketChannel.read(buffer) > 0) {
                            buffer.flip();
                            System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +
                                    "，服务端收到客户端发送的数据：" + new String(buffer.array(), 0, buffer.limit()));
                            buffer.clear();
                        }
                        // 关闭通道，如果不关闭，此通道将会一直打开，
                        // 且里面的数据将一直可读，就会造成selector.select()一直等于1
                        // socketChannel.close();
                    }

                    // 取消选择键，避免每次都是有效的
                    iterator.remove();
                }
            }
        }
    }
}