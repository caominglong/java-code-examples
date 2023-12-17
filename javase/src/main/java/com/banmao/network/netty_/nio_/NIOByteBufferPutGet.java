package com.banmao.network.netty_.nio_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/15 下午8:27
 * @description
 */
public class NIOByteBufferPutGet {



    public static void main(String[] args) {
        // 创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 类型化放入数据

        buffer.putInt(20);

        buffer.putLong(90);

        buffer.putChar('上');

        buffer.putShort((short) 4);

        // 取出
        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }


    @Test
    public void readOnlyBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte)i);
        }

        // 读取
        buffer.flip();

        // 得到只读的buffer
        ByteBuffer buffer1 = buffer.asReadOnlyBuffer();
        System.out.println(buffer1);

        while (buffer1.hasRemaining()) {
            System.out.println(buffer1.get());
        }

        // 写入
        buffer.flip();

        buffer1.put((byte)20);
    }


    @Test
    public void mappedBufferTest() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("file01.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        // 参数2：可以直接修改的起始位置
        // 参数3：映射到内存到大小，即将file01.txt的多个字节映射到内存，可以直接修改到范围就是[0,5)
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'H');

        map.put(3, (byte) '9');

        map.put(5, (byte) 'K');

        randomAccessFile.close();
    }

    @Test
    public void scatterAndGattter() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("file01.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer4 = ByteBuffer.allocate(1024);

        ByteBuffer[] byteBuffers = new ByteBuffer[]{byteBuffer1, byteBuffer2, byteBuffer3, byteBuffer4};
        channel.read(byteBuffers);

        channel.close();
        fileInputStream.close();
    }
}