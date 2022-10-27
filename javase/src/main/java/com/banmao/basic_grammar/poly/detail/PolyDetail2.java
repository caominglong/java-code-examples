package com.banmao.basic_grammar.poly.detail;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/24 下午10:36
 * @description
 */
public class PolyDetail2 {

    public static void main(String[] args) {
        // 属性没有重写之说，属性的值看编译类型
        Base base = new Sub();
        System.out.println(base.count);
    }
}

class Base { // 父类
    int count = 10; // 属性
}

class Sub extends Base {
    int count = 20;
}