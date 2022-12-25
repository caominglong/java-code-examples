package com.banmao.advanced_grammar.io.homework_;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午7:07
 * @description
 */
public class HomeWork01 {

    @Test
    public void m1() {
        String filePath = "/Users/cao/Desktop/mulu/mytemp";
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 在此文件夹下，创建文件hello.txt
        File file2 = new File(filePath + "/hello.txt");
        try {
            if (!file2.exists()) {
                file2.createNewFile();
                System.out.println("创建文件成功");
            } else {
                System.out.println("已经存在，不需要创建");
            }
            // 往文件中写入数据
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write("hello world");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}