package com.banmao.advanced_grammar.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description  反向引用的案例
 */
public class RegExp07 {

    public static void main(String[] args) {
        // 反向引用常用于匹配重复的字符

        // 1、匹配两个连续相同的数字 (\\d)\\1
        // 2、匹配五个连续相同的数字 (\\d)\\1{4}
        // 3、匹配个位与千位相同，十位与佰位相同 (\\d)(\\d)\\2\\1

        String content = "hello jack tom11 tom2yyy xxx";

        // 1、非贪婪匹配，尽可能匹配短一点
        String regStr = "(\\d)\\1";
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