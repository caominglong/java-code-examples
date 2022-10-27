package com.banmao.basic_grammar.extend_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/23 下午1:57
 * @description 继承的本质
 */
public class ExtendTheory {

    public static void main(String[] args) {
        // 指定new Son()时，内存的布局是怎样的？
        // 1、最先加载GrandPa类信息、然后加载Father类信息、然后加载son类信息
        // 2、堆中分配一个地址空间。
        // 2.1、先给爷爷分配空间，
        Son son = new Son();
    }
}

class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
}

class Father extends GrandPa {
    String name = "大头爸爸";
    int age = 39;
}

class Son extends Father {
    String name = "大头儿子";
}