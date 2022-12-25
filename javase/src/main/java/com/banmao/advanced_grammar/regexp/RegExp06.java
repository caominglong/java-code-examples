package com.banmao.advanced_grammar.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description 非贪婪匹配
 */
public class RegExp06 {

    public static void main(String[] args) {
        String content = "hello111111 ok";

        // 1、非贪婪匹配，尽可能匹配短一点
        String regStr = "\\d+?";
        // 2、创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        // 3、创建匹配器
        // 说明：创建匹配器matcher，按照正则表达式的规则 去匹配content字符串
        Matcher matcher = pattern.matcher(content);

        // 4、开始匹配
        
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}