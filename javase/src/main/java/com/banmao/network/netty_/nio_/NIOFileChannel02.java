package com.banmao.network.netty_.nio_;

import java.io.File;
import java.io.FileInputStream;
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
public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {
        // 创建一个输出流 -> channel
        File file = new File("file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 通过fileOutputStream获取fileChannel
        FileChannel channel = fileInputStream.getChannel();
        // 创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer);

        // 反转buffer
        buffer.flip();

        System.out.println(new String(buffer.array(), 0, buffer.limit()));

        channel.close();

        fileInputStream.close();
    }
}