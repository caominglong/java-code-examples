package com.banmao.advanced_grammar.io.inputstream_;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午5:41
 * @description System.in代表的是键盘，System.out代表的是显示器
 */
public class SystemIn_ {

    public static void main(String[] args) {
        // 标准输入输出流
        InputStream in = System.in;
        // 运行类型是BufferedInputStream
        System.out.println(in.getClass());

        // 编译类型与运行类型都是PrintStream
        PrintStream out = System.out;
        System.out.println(out.getClass());

        System.out.println("hello 曹明龙！");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        String next = scanner.next();
        System.out.println(next);
    }
}