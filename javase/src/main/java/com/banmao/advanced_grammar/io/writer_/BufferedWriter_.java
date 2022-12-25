package com.banmao.advanced_grammar.io.writer_;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午3:20
 * @description
 */
public class BufferedWriter_ {

    @Test
    public void writeFile() {
        String filePath = "/Users/cao/Desktop/mulu/a/a.txt";
        BufferedWriter bufferedWriter = null;
        try {
            // 如果需要追加模式，需要在节点流上添加参数
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("ok");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}