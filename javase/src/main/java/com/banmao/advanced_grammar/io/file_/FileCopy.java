package com.banmao.advanced_grammar.io.file_;

import org.junit.Test;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午12:19
 * @description
 */
public class FileCopy {

    public static void main(String[] args) {
        FileCopy fileCopy = new FileCopy();
        try {
            fileCopy.fileCopy(new File("/Users/cao/Desktop/mulu/杭州书屋.jpg"), "/Users/cao/Desktop/mulu/a/杭州书屋.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重点：这里destPath一定要是一个文件的路径，而不是一个文件夹（目录）的路径。
     * 关键在于：是将一个已存在的文件数据写入到另一个磁盘上的文件
     * @param file
     * @param destPath
     * @throws IOException
     */
    public void fileCopy(File file, String destPath) throws IOException {
        // 将file拷贝到destPath
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(destPath);
        byte[] buf = new byte[1024];
        int readLength = 0;
        while ((readLength = fis.read(buf)) != -1) {
            fos.write(buf, 0, readLength);
        }
        fis.close();
        fos.close();
    }
}