package com.banmao.advanced_grammar.io.outputstream_;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午6:06
 * @description
 */
public class PrintStream_ {

    public static void main(String[] args) throws FileNotFoundException {
        // 我们可以修改打印流输出的位置
        System.setOut(new PrintStream("/Users/cao/Desktop/mulu/print.txt"));
        System.out.println("曹命令功能");
    }
}