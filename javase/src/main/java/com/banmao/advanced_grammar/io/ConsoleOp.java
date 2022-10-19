package com.banmao.advanced_grammar.io;

import java.io.Console;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/9/4 下午2:27
 * @description 从控制台输入
 */
public class ConsoleOp {

    public String inFromConsole() {
        Console console = System.console();
        String username = console.readLine("User name：");
        char[] password = console.readPassword("Password：");
        String s = String.valueOf(password);
        System.out.println("username：" + username + "password：" + password);
        return username + password;
    }

    public static void main(String[] args) {
        // 1、Console只能用在原始的控制台中，在Eclipseh或者其他IDE的控制台是用不了的
        ConsoleOp consoleOp = new ConsoleOp();
        // consoleOp.inFromConsole();

        // 2、
    }
}