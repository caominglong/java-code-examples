package com.banmao.basic_grammar.basic_oop.internal_class;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午2:38
 * @description 匿名内部类
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }

}

class Outer04 {
    private int n1 = 10;
    public void method() {
        // 基于接口的匿名内部类
        // 1、需求：想使用接口A，并创建对象
        // 2、传统方式：是写一个类，实现接口，重写方法
        // 3、如果类只使用一次，那么就会很浪费。
        // 4、可以使用匿名内部类来简化开发
        // 5、tiger的编译类型是什么？编译类型是A
        // 运行类型是什么？运行类型是匿名内部类

        A tiger = new A() {

            @Override
            public void cry() {
                System.out.println("老虎叫");
            }
        };
        tiger.cry();

        // 7、jdk底层在创建匿名内部类Outer04$1，立即就创建了Outer04$1实例，并且把地址返回给tiger
        // 8、匿名内部类使用一次就不能再用了
        System.out.println(tiger.getClass());


        // 演示基于类的匿名内部类
        // 底层会生成匿名内部类
        Father father = new Father("jack") {

            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();
        System.out.println("Father的运行类型是：" + father.getClass());
    }
}

interface A {
    void cry();
}

class Father {
    public Father(String name) {

    }
    public void test() {

    }
}