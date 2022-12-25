package com.banmao.advanced_grammar.collections.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/22 下午9:49
 * @description
 */
public class TreeSet_ {

    public static void main(String[] args) {


        // 当使用TreeSet的无参构造器时，创建TreeSet，仍然是无序的。
        TreeSet treeSet = new TreeSet();

        // 添加顺序
        treeSet.add("小明");
        treeSet.add("大黄");
        treeSet.add("李刚");
        treeSet.add("春红");

        System.out.println("treeSet=" + treeSet);


        // 如果需要按照指定顺序来排序，需要使用TreeSet的有参构造器
        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}