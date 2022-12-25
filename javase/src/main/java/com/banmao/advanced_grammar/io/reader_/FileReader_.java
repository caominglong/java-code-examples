package com.banmao.advanced_grammar.io.reader_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午12:31
 * @description
 */
public class FileReader_ {

    @Test
    public void readFileByChar() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            int b = 0; // 读取到的字符
             while ((b = fileReader.read()) != -1) {
                 System.out.print((char) b);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void readFileByByte() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            int readLength = 0; // 读取到的字符
            byte[] bytes = new byte[8];
            while ((readLength = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readLength));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}