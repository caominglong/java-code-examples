package com.banmao.advanced_grammar.java8.lambda_;

import org.junit.Test;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/25 下午4:14
 * @description
 * 1、举例：(o1, o2) -> Integer.compare(o1, o2)
 * 2、-> 箭头符(Lambda操作符)
 * 左边：Lambda的形参列表
 * 右边：lambda体（其实就是重写的抽象方法的方法体）
 */
public class Lambda02 {

    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        System.out.println("*****************");

        Runnable r2 = () -> System.out.println("我爱杭州西湖");

        r2.run();
    }
}