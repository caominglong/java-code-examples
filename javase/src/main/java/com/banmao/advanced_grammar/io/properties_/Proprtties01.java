package com.banmao.advanced_grammar.io.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午6:14
 * @description
 */
public class Proprtties01 {

    public static void main(String[] args) throws IOException {
        URL resource = Proprtties01.class.getResource("/");
        System.out.println(resource.getPath());
        BufferedReader br = new BufferedReader(new FileReader(resource.getPath()  + "/Mysql.properties"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println("key=" + split[0]);
            System.out.println("value=" + split[1]);
        }
        br.close();
    }
}