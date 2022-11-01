package com.banmao.basic_grammar.basic_oop.internal_class;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午1:48
 * @description
 */
public class InnerClass01 {


}

class Outer {
    // 属性
    private int n1 = 10;

    // 构造器
    public Outer(int n1) {
        this.n1 = n1;
    }
    public void m1() {
        System.out.println("方法");
    }

    {
        // 代码块
        System.out.println("代码块");
    }

    class Inner {
        // 内部类
    }
}