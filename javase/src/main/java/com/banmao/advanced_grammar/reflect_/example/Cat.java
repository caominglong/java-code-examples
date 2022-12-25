package com.banmao.advanced_grammar.reflect_.example;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午8:03
 * @description
 */
public class Cat {

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    private String name = "招财猫";

    public void hi() {
        System.out.println(name);
    }

}