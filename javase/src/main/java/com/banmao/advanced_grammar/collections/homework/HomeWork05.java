package com.banmao.advanced_grammar.collections.homework;


import java.util.TreeSet;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/26 下午1:39
 * @description
 */
public class HomeWork05 {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        // 会报异常，添加的类必须要实现Compareable接口
        treeSet.add(new Person());
    }
}

class Person {

}