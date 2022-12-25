package com.banmao.advanced_grammar.network_programm.udp_.send_;

import java.io.IOException;
import java.net.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午5:35
 * @description
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        // 创建DatagramSocket，准备发送和接收数据（9998端口接收数据）
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        String str = "hello udp";
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);

        // 关闭资源
        datagramSocket.close();
    }
}