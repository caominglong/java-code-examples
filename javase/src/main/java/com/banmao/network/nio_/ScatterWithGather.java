package com.banmao.network.nio_;


import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/12 下午2:05
 * @description
 * 分散（Scatter）与聚集（Gatter）
 * 1、分散读取（Scatter Reads）：将通道中的数据分散到多个缓冲区
 * 2、聚集写入（Gatter Writes）：将多个缓冲区的数据聚集到通道中
 */
public class ScatterWithGather {


    @Test
    public void testScatter() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        // 1、获取通道
        FileChannel channel = randomAccessFile.getChannel();

        // 2、分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        // 3、分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);

        for(ByteBuffer buffer : bufs) {
            buffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("------------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        // 聚集写入
        RandomAccessFile randomAccessFile2= new RandomAccessFile("2.txt", "rw");

        // 通道
        FileChannel channel1 = randomAccessFile2.getChannel();

        // 写入通道
        channel1.write(bufs);

        // 关闭通道
        channel.close();
        channel1.close();
    }
}