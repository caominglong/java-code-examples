package com.banmao.basic_grammar.functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/21 下午8:09
 * @description 递归思想
 */
public class Recursion {

    public static void main(String[] args) {
        T t = new T();
        t.test(4); // 输出2，3，4
        int factorial = t.factorial(5);
        System.out.println(factorial);
        int fibonacci = t.fibonacci(7);
        System.out.println(fibonacci);

        int peaches = t.monkeysEatPeaches(1);
        System.out.println("第一天还未吃的桃子为：" + peaches);

    }
}

class T {
    // 分析
    public void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    // factorial是阶乘的意思
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    // 请使用递归的方式求出斐波那契数1，1，2，3，5，8，13...给你一个整数n，求出他的值是多少
    // 思路分析
    // 1、n=1，value=1
    // n=2，value=1
    // n=3，value=2
    // n=4，value=3
    // n=5，value=5
    // n=6，value=8

    public int fibonacci(int n) {
        // 先定义结束的标记
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacci2(int n) {
        // 先定义结束的标记
        if (n >= -1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci2(n - 1) + fibonacci2(n - 2);
            }
        } else {
            System.out.println("输入的n有误：" + n);
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 猴子吃桃子的问题。有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个，
    // 以后猴子每天都吃一半，并再多吃一个，当第十天时，猴子再吃桃时，发现只剩一个
    // 了，问起初有多少个桃子
    // 思路分析
    // 第1天还没吃的桃子 = （第2天剩余的桃子 + 1） * 2
    // 第2天还没吃的桃子 = （第3天剩余的桃子 + 1） * 2
    // 以此类推
    // 第10天桃子= 1
    public int monkeysEatPeaches(int day) {
        // 设置结束标记
        if (day == 10) {
            return 1;
        } else if (day >= 1 && day <= 9){
            return (monkeysEatPeaches(day + 1) + 1) * 2;
        } else {
            System.out.println("day in 1-9");
            return -1;
        }
    }



}
