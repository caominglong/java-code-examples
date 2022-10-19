package com.banmao.basic_grammar.file;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/9/4 下午8:55
 * @description 文件操作
 */
public class FileOp {

    public void getFile() {
        try {
            Scanner in = new Scanner(Paths.get("1.txt"), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}