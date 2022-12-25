package com.banmao.advanced_grammar.io.writer_;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午3:23
 * @description 文件拷贝
 */
public class BufferedCopy {

    public static void main(String[] args) {
        BufferedCopy bufferedCopy = new BufferedCopy();
        String srcPath = "/Users/cao/Desktop/mulu/a.txt";
        String destPath = "/Users/cao/Desktop/mulu/b/a.txt";
        bufferedCopy.fileCopy(srcPath, destPath);
    }

    public void fileCopy(String srcPath, String destPath) {
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcPath));
            bufferedWriter = new BufferedWriter(new FileWriter(destPath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // 每读取一行，就写入一行
                bufferedWriter.write(line);
                // 添加换行符
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}