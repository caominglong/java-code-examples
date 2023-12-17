package com.banmao.network.netty_.nio_.file_transform;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/18 下午8:53
 * @description
 */
public class NewIoClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("localhost", 7001));

        String fileName = "file01.txt";
        // 创建一个文件channel
        FileChannel channel = new FileInputStream(fileName).getChannel();

        // 准备发送
        long startTime = System.currentTimeMillis();
        long l = channel.transferTo(0, channel.size(), socketChannel);
        System.out.println("发送的总的字节数=" + l + "，耗时" + (System.currentTimeMillis() - startTime));
    }

}