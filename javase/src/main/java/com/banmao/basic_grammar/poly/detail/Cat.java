package com.banmao.basic_grammar.poly.detail;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/24 下午10:02
 * @description
 */
public class Cat extends Animal{

    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catchMouse() { // Cat特有方法
        System.out.println("猫抓老鼠");
    }
}