package com.banmao.advanced_grammar.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description  验证电子邮件是否合法
 */
public class RegExp09 {

    public static void main(String[] args) {

        // 1、只能有一个@
        // 2、@前面是用户名，可以是a-z A-Z 0-9 _-字符
        // 3、@后面是域名，并且域名只能是英文字母，比如sohu.com或者tsinghua.org.cn
        // 写出对应的正则表达式，验证输入的字符串是否满足规则

        String str = "@ssss";
        // String的matches是整体匹配
        boolean matches = str.matches("[\\w-]*@[a-zA-Z]*");
        System.out.println("是否满足规则" + matches);
    }
}