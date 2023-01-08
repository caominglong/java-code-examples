package com.banmao.advanced_grammar.java8.methodref;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/25 下午9:16
 * @description
 *
 * 1、使用情景：当传递给lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 2、方法引用本质也是lambda表达式，所以也是函数式接口的实例
 * 3、使用格式：类（或对象）:: 方法名
 * 4、具体分为以下三种情况：
 * （1）对象 :: 实例方法
 * （2）类 :: 静态方法
 * （3）类 :: 非静态方法
 */
public class MethodRef01 {

    /**
     * 情况1：对象 :: 实例方法
     */
    @Test
    public void test1() {
        Consumer<String> con = System.out::println;
        con.accept("您好！");
    }
}