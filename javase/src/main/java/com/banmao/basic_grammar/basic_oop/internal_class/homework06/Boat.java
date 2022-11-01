package com.banmao.basic_grammar.basic_oop.internal_class.homework06;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午8:52
 * @description 划船（属于交通方式的一种）
 */
public class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("使用划船的方式赶路！");
    }
}