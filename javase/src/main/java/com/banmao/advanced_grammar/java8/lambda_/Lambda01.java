package com.banmao.advanced_grammar.java8.lambda_;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/25 下午4:14
 * @description
 */
public class Lambda01 {

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

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        comparator.compare(10,20);

        System.out.println("*****************");

        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator2.compare(10, 5));

        // 方法引用
        comparator2 = Integer::compare;
        System.out.println(comparator2.compare(10, 21));
    }
}