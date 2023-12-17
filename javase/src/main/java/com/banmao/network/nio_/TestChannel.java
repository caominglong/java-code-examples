package com.banmao.network.nio_;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/11 下午6:06
 * @description
 * （1）通道（Channel）：用于源节点与目标节点的连接，
 *      在Java NIO中负责缓冲区中数据的传输，Channel本身不存储数据，因此需要配合缓冲区进行传输
 * （2）通道的主要实现类
 *      java.nio.channels.Channel接口：
 *      [1] FileChannel
 *      [2] SocketChannel
 *      [3] ServerSocketChannel
 *      [4] DatagramChannel
 * （3）获取通道
 *      1、Java针对支持通道的类提供了getChannel()方法
 *      本地IO
 *      [1] FileInputStream/FileOutputStream
 *      [2] RandomAccessFile
 *      网络IO
 *      [1]Socket
 *      [2]ServerSocket
 *      DatagramSocket
 *  2、在JDK1.7中的NIO2，针对各个通道提供了一个静态方法open()
 *  3、在JDK1.7中的NIO2的Files工具类newByteChannel()
 *
 */
public class TestChannel {

    // 1、利用通道完成文件的复制
    @Test
    public void test1() {
        File file = new File("2.jpeg");
        System.out.println(file.getName());
        System.out.println(System.getProperty("user.dir"));
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        FileChannel channel = null;
//        FileChannel outChannel = null;
//        try {
//            fis = new FileInputStream("/Users/cao/Documents/workspace/java-code-examples/javase/src/main/java/com/banmao/network/nio_/1.jpeg");
//            fos = new FileOutputStream("2.jpeg");
//            // "/Users/cao/Documents/workspace/java-code-examples/javase"
//
//            // 获取通道
//            channel = fis.getChannel();
//            outChannel = fos.getChannel();
//            // 分配一个指定大小的缓冲区
//            ByteBuffer buf = ByteBuffer.allocate(1024);
//
//            // 将通道中的数据数据存入缓冲区
//            while (channel.read(buf) != -1) {
//
//                ByteBufferUtil.printByteBufferProperties(buf);
//
//                // 将缓冲区切换成读取数据模式
//                buf.flip();
//
//                ByteBufferUtil.printByteBufferProperties(buf);
//
//                // 将缓冲区的数据写入通道中
//                outChannel.write(buf);
//
//                // 清空缓冲区
//                buf.clear();
//
//                ByteBufferUtil.printByteBufferProperties(buf);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (channel != null) {
//                try {
//                    channel.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (outChannel != null) {
//                try {
//                    outChannel.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }

}