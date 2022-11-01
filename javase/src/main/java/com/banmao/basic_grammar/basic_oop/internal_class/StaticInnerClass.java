package com.banmao.basic_grammar.basic_oop.internal_class;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午4:00
 * @description
 */
public class StaticInnerClass {

    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        // 外部其它类访问静态内部类
        // 方式一：通过类名直接访问静态内部类，前提是满足访问权限
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();

        // 方式二：通过写一个方法，返回静态内部类的对象实例
        Outer10.Inner10 inner10Instance = outer10.getInner10Instance();

        // 方式三：通过写一个方法，返回静态内部类的对象实例，用类来访问
        Outer10.Inner10 inner10Instance3 = Outer10.getInner10Instance();
    }
}

class Outer10 {
    private int n1 = 10;
    public static String name = "张三";

    public static class Inner10 {
        public void say() {
            System.out.println(name);
        }
    }

    public void m1() {
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public static Inner10 getInner10Instance() {
        return new Inner10();
    }
}