package com.banmao.basic_grammar.basic_oop.internal_class.homework06;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午8:50
 * @description 骑马（属于交通工具的一种）
 */
public class Horse implements Vehicles {

    // 构造函数私有化
    private void horse() {

    }

    @Override
    public void work() {
        System.out.println("使用骑马的方式赶路！");
    }
}