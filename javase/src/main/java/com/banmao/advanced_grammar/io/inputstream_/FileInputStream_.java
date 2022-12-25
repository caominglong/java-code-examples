package com.banmao.advanced_grammar.io.inputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/2 下午10:43
 * @description
 */
public class FileInputStream_ {

    public static void main(String[] args) {
        FileInputStream_ fileInputStream_ = new FileInputStream_();
        // fileInputStream_.readFile01();
        fileInputStream_.readFile02();
    }

    public void readFile01() {
        String filePath = "/Users/cao/Desktop/new2.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            int readValue = 0;
            while ((readValue = fis.read()) != -1) {
                System.out.print((char) readValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件，释放资源
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用read(byte[] b)来读取
     */
    public void readFile02() {
        String filePath = "/Users/cao/Desktop/new2.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            byte[] bytes = new byte[8];
            int readValue = 0;
            // fis.read(bytes)，如果读取正常，返回的是实际读取的字节数，如果没有内容了，那么返回-1
            while ((readValue = fis.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readValue));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件，释放资源
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}