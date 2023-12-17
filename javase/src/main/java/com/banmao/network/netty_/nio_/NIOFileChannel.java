package com.banmao.network.netty_.nio_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/15 下午7:27
 * @description 使用FileChannel写入文件
 */
public class NIOFileChannel {

    public static void main(String[] args) throws IOException {
        String str = "hello，曹明龙";
        // 创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("file01.txt");
        // 通过fileOutputStream获取fileChannel
        FileChannel channel = fileOutputStream.getChannel();
        // 创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(str.getBytes());

        // 反转buffer
        buffer.flip();

        channel.write(buffer);

        channel.close();

        fileOutputStream.close();
    }
}