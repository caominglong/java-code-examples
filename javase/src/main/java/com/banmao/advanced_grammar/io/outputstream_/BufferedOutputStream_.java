package com.banmao.advanced_grammar.io.outputstream_;

import com.banmao.advanced_grammar.io.writer_.BufferedCopy;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午3:36
 * @description
 */
public class BufferedOutputStream_ {

    public static void main(String[] args) {
        BufferedOutputStream_ bufferedCopy = new BufferedOutputStream_();
        String srcPath = "/Users/cao/Desktop/mulu/杭州书屋.jpg";
        String destPath = "/Users/cao/Desktop/mulu/b/杭州书屋2.jpg";
        bufferedCopy.fileCopy2(srcPath, destPath);
    }

    public void fileCopy2(String srcPath, String destPath) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));
            int readLength = 0;
            byte[] buf = new byte[1024];
            while ((readLength = bis.read(buf)) != -1) {
                // 每读取一行，就写入一行
                bos.write(buf, 0 ,readLength);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}