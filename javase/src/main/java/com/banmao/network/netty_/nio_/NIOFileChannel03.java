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
public class NIOFileChannel03 {

    public static void main(String[] args) throws IOException {
        // 创建一个输出流 -> channel
        File file = new File("file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 通过fileOutputStream获取fileChannel
        FileChannel channel = fileInputStream.getChannel();

        // 拷贝文件

        FileOutputStream fileOutputStream = new FileOutputStream("file02.txt");
        FileChannel channel1 = fileOutputStream.getChannel();


        // 创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);






//        // 不知道文件有多大，需要循环写入
//        while(channel.read(buffer) != -1) {
//            // 反转buffer
//            buffer.flip();
//            channel1.write(buffer);
//        }


        while (true) { // 循环读取
            int read = channel.read(buffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }

            // 将buffer中的数据写入文件file02.txt
            buffer.flip();
            channel1.write(buffer);
            // 清空buffer
            // buffer.clear();
        }

        channel.close();

        fileInputStream.close();
    }
}