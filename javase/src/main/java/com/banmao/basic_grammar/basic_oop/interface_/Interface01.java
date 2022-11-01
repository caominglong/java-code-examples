package com.banmao.basic_grammar.basic_oop.interface_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 上午11:14
 * @description
 */
public interface Interface01 {

    public int n1 = 10;
    public abstract void h1();

    default public void hello() {
        System.out.println("hello...");
    }

    // jdk8后，可以有静态方法
    public static void staticMethod() {
        System.out.println("staticMethod");
    }
}

class A implements Interface01 {

    @Override
    public void h1() {
        System.out.println("hi()...");
    }
}