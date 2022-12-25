package com.banmao.advanced_grammar.io.outputstream_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午6:09
 * @description
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.write("hi 北京你好！");
        printWriter.close();

        // 会输出到文件
        PrintWriter printWriter2 = new PrintWriter(new FileWriter("/Users/cao/Desktop/mulu/printWrite.txt"));
        printWriter2.write("hi 北京你好！");
        printWriter2.close();
    }
}