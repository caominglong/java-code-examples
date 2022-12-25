package com.banmao.advanced_grammar.regexp;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description  验证是否是整数还是小数（要考虑正数和负数）
 */
public class RegExp10 {

    public static void main(String[] args) {

        String str = "-87.9.8";
        // String的matches是整体匹配
        boolean matches = str.matches("^[-+]?([1-9]\\d*|0)(\\.\\d+)?$");
        if (matches) {
            System.out.println("小数");
        } else {
            System.out.println("整数");
        }
    }
}