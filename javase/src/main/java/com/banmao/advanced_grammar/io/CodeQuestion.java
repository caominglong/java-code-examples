package com.banmao.advanced_grammar.io;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午5:47
 * @description
 */
public class CodeQuestion {

    /**
     * 重要：以下代码有隐患，当文件的编码被修改了，比如修改为GBK了，java中是采用UTF-8来读取文件的，
     * 所以编码解码的字符集不同，所以可能会造成乱码问题。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        System.out.println("读取到的内容为：" + line);
        br.close();
    }
}