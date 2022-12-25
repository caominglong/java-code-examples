package com.banmao.advanced_grammar.io.reader_;

import org.junit.Test;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午5:55
 * @description
 */
public class InputStreamReader_ {

    @Test
    public void readFileWithCharset() throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/gbk.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());
        br.close();
    }
}