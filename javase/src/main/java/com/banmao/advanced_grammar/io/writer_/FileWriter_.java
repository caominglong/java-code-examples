package com.banmao.advanced_grammar.io.writer_;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午2:28
 * @description
 */
public class FileWriter_ {

    @Test
    public void writeChar01() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write("这是一个字符串");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void writeChar02() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            fileWriter.write('H');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void writeChar03() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            char[] chars = {'a', 'b', 'c'};
            fileWriter.write(chars);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void writeChar04() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            String str = "韩顺平教育";
            fileWriter.write(str.toCharArray(), 0 ,3);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void writeChar05() {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            String str = "韩顺平教育";
            fileWriter.write(str, 0 ,3);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}