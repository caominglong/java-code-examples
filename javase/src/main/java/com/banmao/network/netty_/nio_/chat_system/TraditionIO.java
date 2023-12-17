package com.banmao.network.netty_.nio_.chat_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/18 下午7:01
 * @description
 */
public class TraditionIO {

    /**
     * 使用传统方式进行网络传输
     */
    public void copyFile() throws IOException {
        File file = new File("file01.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        // 创建一个字节数组，以文件的长度作为数组的定义范围
        byte[] bytes = new byte[(int)file.length()];
        // 将文件的数据读入字节数组
        randomAccessFile.read(bytes);

        // 获取一个socket，将数据写入网络
        Socket socket = new ServerSocket(8080).accept();
        socket.getOutputStream().write(bytes);
    }
}