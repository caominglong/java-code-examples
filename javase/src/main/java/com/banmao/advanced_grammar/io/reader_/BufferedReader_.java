package com.banmao.advanced_grammar.io.reader_;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午3:14
 * @description
 */
public class BufferedReader_ {

    @Test
    public void readFile() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            // 当返回为null时代表读取结束
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}