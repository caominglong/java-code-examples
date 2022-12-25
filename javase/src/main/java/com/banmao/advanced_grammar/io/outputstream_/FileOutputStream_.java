package com.banmao.advanced_grammar.io.outputstream_;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 上午11:23
 * @description
 */
public class FileOutputStream_ {

    public static void main(String[] args) {
        FileOutputStream_ fileOutputStream_ = new FileOutputStream_();
        try {
            fileOutputStream_.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用FileOutputStream往a.txt中写入hello world!
     *
     * 重要：FileOutputStream会自动常见文件，如果此文件在指定目录下不存在时，
     * 但前提是目录必须存在，目录不存在的情况是不行的，会报错
     */
    public void writeFile() throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            // 文件不存在，创建文件
            file.createNewFile();
        }
        // 往文件里写数据
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("hello world".getBytes());
        fos.close();
    }

    @Test
    public void writeFile02() throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/a/a.txt";
        // 往文件里写数据
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write("hello world".getBytes());
        fos.close();
    }

    @Test
    public void writeFile03() throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/a.txt";
        // 往文件里写数据
        // 第二个参数等于true，代表可以追加
        FileOutputStream fos = new FileOutputStream(filePath, true);
        byte[] bytes = "世界杯".getBytes();
        fos.write(bytes, 0, bytes.length);
        fos.close();
    }

    /**
     * 验证文件不存在时，是否能创建File对象
     *
     * 重要结论：当文件不存在时，也能获取文件的一些信息，当这个文件其实未在磁盘真实存在，
     * 相当于是一个内存里的虚拟文件
     */
    @Test
    public void validateFileNoExist() {
        String filePath = "/Users/cao/Desktop/mulu/b.txt";
        File file = new File(filePath);
        System.out.println("文件名：" + file.getName());
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        System.out.println("文件父级目录：" + file.getParent());
        System.out.println("文件大小（字节）：" + file.length());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件是否目录：" + file.isDirectory());
    }
}