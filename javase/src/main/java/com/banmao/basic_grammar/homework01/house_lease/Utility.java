package com.banmao.basic_grammar.homework01.house_lease;

import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/28 下午7:47
 * @description 处理各种情况的用户输入，并且能够按照程序员的需求，得到用户的控制台输入
 */
public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取键盘输入的一个字符
     * @return 一个字符
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 读取键盘输入的一个字符，如果直接按回车，则返回指定的默认值
     * @param defaultChar
     * @return
     */
    public static char readChar(char defaultChar) {
        String str = readKeyBoard(1, true);
        return str.equals("") ? defaultChar : str.charAt(0);
    }

    /**
     * 读取键盘输入的整数或默认值。如果直接回车，则返回默认值
     * @param defaultValue
     * @return
     */
    public static int readInt(int defaultValue) {
        int n;
        for(;;) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            // 异常处理
            try {
                n = Integer.parseInt(str);
                break;
            } catch (ClassCastException w) {

            }
        }
        return n;
    }


    /**
     * 读取键盘输入的字符串（指定长度）
     * @param limit 限制的长度
     * @return
     */
    public static String readString(int limit) {
        String str = readKeyBoard(limit, true);
        return str;
    }


    /**
     * 读取键盘输入的字符串（指定长度）
     * @param limit 限制的长度
     * @param defaultValue 指定的默认值
     * @return
     */
    public static String readString(int limit,  String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }


    private static String readKeyBoard(int limit, boolean blankReturn) {

        // 定义字符串
        String line = "";

        // scanner.hasNextLine() 判断有没有下一行
        while (scanner.hasNextLine()) {
            line = scanner.nextLine(); // 读取这一行

            // 如果line.length=0。表明用户没有输入任何内容，直接回车。那么给默认值
            if (line.length() == 0) {
                if (blankReturn) {
                    // 为true，代表可以返回空串
                    return line;
                } else {
                    continue;
                }
            }

            // 如果用户输入的内容大于limit，就提示重写输入
            // 如果用户输入的内容 > 0 <= limit,我就接收
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（不能大于）" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }

    /**
     * 读取键盘输入的确认选项，Y或N
     * @return
     */
    public static char readConfirmSelection() {
        System.out.println("请输入您的选择：Y/N，请小心选择");
        char c;
        for (;;) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
}