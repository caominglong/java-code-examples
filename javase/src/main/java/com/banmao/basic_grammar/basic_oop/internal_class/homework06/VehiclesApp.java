package com.banmao.basic_grammar.basic_oop.internal_class.homework06;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午8:54
 * @description
 */
public class VehiclesApp {

    public static void main(String[] args) {

        // 实例化person类"唐僧"，要求一般情况下用Horse做交通工具，遇到大河时用Boat做交通工具
        Person tan = new Person("唐僧", new Boat());
        // 这里涉及到编程思想，将具体的需求场景定义为方法，这里定义两个方法common()、crossRiver()
        // 分别代表一般情况赶路、过河赶路
        tan.common();
        tan.crossRiver();
    }
}