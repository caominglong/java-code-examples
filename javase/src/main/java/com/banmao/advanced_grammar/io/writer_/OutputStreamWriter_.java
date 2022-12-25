package com.banmao.advanced_grammar.io.writer_;

import org.junit.Test;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午6:00
 * @description
 */
public class OutputStreamWriter_ {

    @Test
    public void writeFileWithCharset() throws IOException {
        String filePath = "/Users/cao/Desktop/mulu/gbk.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
        BufferedWriter fw = new BufferedWriter(osw);
        fw.write("这是一个好人");
        fw.close();
    }
}