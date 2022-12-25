package com.banmao.advanced_grammar.io.file_;

import java.io.File;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/2 下午9:07
 * @description 文件的常用操作
 */
public class FileOp {

    public static void main(String[] args) {
        // 创建文件
        FileOp fileOp = new FileOp();
        fileOp.create02();
        fileOp.create03();
    }

    // 1、第一种方式，new File(String filePath)
    public void create01() {
        File file = new File("/Users/cao/Desktop/new.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方式2：new File(File parent, String child)
    // 根据父目录文件 + 子路径创建
    public void create02() {
        String parent = "/Users/cao/Desktop";
        File parentFile = new File(parent);
        String fileName = "new1.txt";
        File file2 = new File(parentFile, fileName);
        try {
            file2.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方式3：new File(File parent, String child)
    // 根据父目录 + 子路径创建
    public void create03() {
        String parent = "/Users/cao/Desktop";
        String fileName = "new2.txt";
        File file2 = new File(parent, fileName);
        try {
            file2.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}