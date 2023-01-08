package com.banmao.advanced_grammar.java8.lambda_;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/25 下午4:14
 * @description
 * 消费型接口的应用
 */
public class Lambda03 {

    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        happyTime(500, money -> System.out.println("学习太累了，歇着喝口水，价格为：" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }
}