package com.banmao.advanced_grammar.collections.homework;

import java.util.TreeSet;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/26 下午12:04
 * @description
 */
public class HomeWork04 {

    public static void main(String[] args) {
        // 简答题：分析HashSet和TreeSet分别是如何去重的

        // HashSet：
        // hashSet底层是使用了hashMap的底层机制来实现的，它其实就是使用了HashMap的key，value存的是空对象。
        // key在hashMap中，如果key的hash值相等，并且equals比较后的值也相等，那么就判定此key已存在。
        // TreeSet：
        // TreeSet底层是使用了TreeMap的底层机制来实现的。它需要通过传入一个比较器来进行定义元素的顺序。如果通过两个元素比较后，发现相等，那么
        // 当前要加入的元素将不会被加入（但值会被覆盖）。如果没有传入比较器，使用的是key实现的Compareable的compareTo方法来去重（定义顺序）

    }
}