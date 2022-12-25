package com.banmao.advanced_grammar.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description  反向引用的案例
 */
public class RegExp08 {

    public static void main(String[] args) {

        String content = "我....我要....学学学学....编程java";

        // 1、非贪婪匹配，尽可能匹配短一点
        String regStr = "([.])\\1{3}";
        // 2、创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        // 3、创建匹配器
        // 说明：创建匹配器matcher，按照正则表达式的规则 去匹配content字符串
        Matcher matcher = pattern.matcher(content);

        // 4、开始匹配
        // 将....替换为空字符
        String content2 = matcher.replaceAll("");
        // System.out.println(s); // 得到我我要学学学学编程java
        // 接下来继续处理
        String regStr2 = "(.)\\1+";
        Pattern pattern2 = Pattern.compile(regStr2);
        Matcher matcher2 = pattern2.matcher(content2);
        while (matcher2.find()) {
            System.out.println("找到：" + matcher2.group(0));
        }
//        while (matcher.find()) {
//            System.out.println("找到：" + matcher.group(0));
//
//        }
        // 使用反向引用$1来替换匹配到的内容
        String content3 = matcher2.replaceAll("$1");
        System.out.println("content3=" + content3);
    }
}