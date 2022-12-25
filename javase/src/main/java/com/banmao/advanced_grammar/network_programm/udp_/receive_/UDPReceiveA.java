package com.banmao.advanced_grammar.network_programm.udp_.receive_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午5:35
 * @description
 */
public class UDPReceiveA {
    public static void main(String[] args) throws IOException {
        // 准备在9999端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //构建一个DatagramPacket,准备接收数据
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //  准备接收数据，调用接收方法，将通过网络传输的数据填充到空的DatagramPacket中
        // 这里如果没有数据包的话，就会阻塞
        datagramSocket.receive(datagramPacket);

        // 拆包，取出里面的数据
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));

        // 关闭资源
        datagramSocket.close();
    }
}