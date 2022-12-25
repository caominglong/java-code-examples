package com.banmao.advanced_grammar.io.homework_;

import org.junit.Test;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午7:07
 * @description
 */
public class HomeWork02 {

    @Test
    public void m1() throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = "";
        int i = 1;
        while ((line = br.readLine()) != null) {
            System.out.println(i + "\t" + line);
            i++;
        }
    }
}