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
public class NIOFileChannel04 {

    public static void main(String[] args) throws IOException {
        // 创建相关流
        FileInputStream fileInputStream = new FileInputStream("1.jpeg");

        FileOutputStream fileOutputStream = new FileOutputStream("2.jpeg");

        // 获取各个流对应的channel
        FileChannel source = fileInputStream.getChannel();
        FileChannel target = fileOutputStream.getChannel();

        // 使用transferForm完成拷贝
        target.transferFrom(source, 0, source.size());

        source.close();
        target.close();

        fileOutputStream.close();
        fileInputStream.close();

    }
}