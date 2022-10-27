package com.banmao.basic_grammar.poly.detail;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/24 下午10:02
 * @description
 */
public class PolyDetail {

    public static void main(String[] args) {

        // 向上转型，父类的引用，指向子类的对象
        // 语法：父类类型 引用名 = new 子类类型();
        Animal animal = new Cat();

        Object obj = new Cat();

        // 编译阶段能调用哪些成员，是由编译类型决定的
        // animal.catchMouse();
        // 最终运行效果是由运行类型决定的，调用方法，从子类开始向上一级级查找方法
    }
}