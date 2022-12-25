package com.banmao.advanced_grammar.network_programm.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午9:31
 * @description  InetAddress表示了ip地址，可看作ip地址的一个抽象
 */
public class InetAddress_ {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 根据指定主机名获取InetAddress对象
        InetAddress host = InetAddress.getByName("longdeMacBook-Pro.local");
        System.out.println(host);

        // 根据域名获取InetAddress对象
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        // 通过InetAddress对象，获取主机地址
        System.out.println("主机地址：" + byName.getHostAddress());

        System.out.println("主机名：" + byName.getHostName());
    }
}