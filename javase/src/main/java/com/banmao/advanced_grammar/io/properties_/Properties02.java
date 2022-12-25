package com.banmao.advanced_grammar.io.properties_;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午6:14
 * @description
 */
public class Properties02 {

    public static void main(String[] args) throws IOException {
        // 使用Properties来读取
        Properties properties = new Properties();
        properties.load(new FileReader(
                "/Users/cao/Documents/workspace/java-code-examples/javase/src/main/resources/Mysql.properties"));
        // 将配置显示在控制台
        properties.list(System.out);

        // 指定得到对应的值
        String pwd = properties.getProperty("pwd");
        System.out.println("密码为：" + pwd);

        // 修改其中的值
        properties.setProperty("user", "100曹");

        // 将配置显示在控制台
        properties.list(System.out);
    }

    @Test
    public void createProperties() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "200曹");
        properties.setProperty("pwd", "1002000");
        FileWriter fileWriter = new FileWriter(
                "/Users/cao/Documents/workspace/java-code-examples/javase/src/main/resources/Mysql2.properties");
        properties.store(fileWriter
                , null);
    }
}