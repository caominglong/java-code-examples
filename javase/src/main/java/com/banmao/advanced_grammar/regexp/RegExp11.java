package com.banmao.advanced_grammar.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description  获取url中指定内容
 */
public class RegExp11 {

    public static void main(String[] args) {

        String content = "http://www.sohu.com:8080/aaa/vbb/index.html";
        String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+[a-z.]+[a-z]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
    }
}