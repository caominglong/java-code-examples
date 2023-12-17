package com.banmao.network.nio_.blocknio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/12 下午3:43
 * @description 阻塞式IO
 * <p>
 * 使用NIO完成网络通信的三个核心：
 * （1）通道（Channel）：负责连接
 * java.nio.channels.Channel接口：
 * SelectableChannel
 * SocketChannel
 * ServerSocketChannel
 * DatagramChannel
 * <p>
 * Pipe.SinkChannel
 * Pipe.SourceChannel
 * <p>
 * （2）缓冲区（Buffer）：负责数据的读取
 * <p>
 * （3）选择器（Selector）：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 */
public class TestBlockingNio {

    // 客户端
    @Test
    public void client() throws IOException {
        //1、获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9098));

        // 分配大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 读取本地文件并发送到服务端去
        FileChannel fileChannel = FileChannel.open(Paths.get("1.jpeg"), StandardOpenOption.READ);

        while (fileChannel.read(buf) != -1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        //4、关闭通道
        fileChannel.close();
        sChannel.close();
    }

    // 服务端
    @Test
    public void server() throws IOException {
        //1、获取通道
        ServerSocketChannel bind = ServerSocketChannel.open().bind(new InetSocketAddress(9098));
        SocketChannel socketChannel = bind.accept();

        // 2、接收客户端数据并保存到本地
        FileChannel fileChannel = FileChannel.open(Paths.get("2.jpeg"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 3、分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //4、接收客户端的数据，并保存到本地
        while (socketChannel.read(buffer) != -1) {
            // 写到文件中
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        fileChannel.close();

        socketChannel.close();

        bind.close();
    }
}