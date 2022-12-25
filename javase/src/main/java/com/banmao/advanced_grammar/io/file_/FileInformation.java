package com.banmao.advanced_grammar.io.file_;

import org.junit.Test;

import java.io.File;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/2 下午9:35
 * @description
 */
public class FileInformation {

    public static void main(String[] args) {

    }

    @Test
    public void info() {
        // 先创建文件对象
        File file = new File("/Users/cao/Desktop/new1.txt");
        // 调用相应方法，得到相应的信息
        System.out.println("文件名：" + file.getName());
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        System.out.println("文件父级目录：" + file.getParent());
        System.out.println("文件大小（字节）：" + file.length());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件是否目录：" + file.isDirectory());
    }
}