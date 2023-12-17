package com.banmao.network.netty_.nio_.file_transform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/18 下午8:53
 * @description 使用nio的方式传输大文件
 */
public class NewIoServer {

    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(7001);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket socket = serverSocketChannel.socket();

        socket.bind(address);

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            int readCount = 0;

            while (true) {
                readCount = socketChannel.read(byteBuffer);
                if (readCount == -1) {
                    break;
                }
                System.out.println(new String(byteBuffer.array()));
                byteBuffer.clear();
            }



        }
    }

}