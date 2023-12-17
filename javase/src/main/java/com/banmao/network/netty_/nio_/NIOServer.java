package com.banmao.network.netty_.nio_;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/15 下午9:33
 * @description
 */
public class NIOServer {

    @Test
    public void server() throws IOException {

        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2、得到一个Selector对象
        Selector selector = Selector.open();

        // 3、绑定端口
        serverSocketChannel.bind(new InetSocketAddress(6666));

        // 4、设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 5、把ServerSocketChannel注册到selector上。关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1s，无连接");
                continue;
            }

            // 如果返回的大于0，则获取到相关到SelectionKey集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 看看各个事件分别是什么
                if (selectionKey.isAcceptable()) {
                    // 连接事件
                    // 给该客户端生成socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);

                    System.out.println("客户端连接连接，生成了SOcketChannel" + socketChannel.hashCode());
                    // 将当前的socketChannel也注册到Selector上
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));


                } else if (selectionKey.isReadable()) {
                    // 可读
                    // 通过key，反向获取Channel
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    // 获取到该channel关联到buffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();

                    // 将通道里的数据，读入到buffer中
                    channel.read(byteBuffer);

                    System.out.println("客户端发送到数据" + new String(byteBuffer.array(), 0 ,byteBuffer.limit()));
                }

                // 手动将集合中移动当前的SelectKey，防止重复操作
                iterator.remove();
            }
        }
    }


    @Test
    public void client() throws IOException {
        // 得到一个通道
        SocketChannel socketChannel = SocketChannel.open();

        // 设置非阻塞模式
        socketChannel.configureBlocking(false);

        // 连接到服务器
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其它工作");
            }
        }

        // 连接成功，发送数据
        String str = "hello, 曹命令";

        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());

        // 发送数据，将byffer写入channel
        socketChannel.write(wrap);


        // 让客户端停在这
        System.in.read();

        socketChannel.close();

    }
}