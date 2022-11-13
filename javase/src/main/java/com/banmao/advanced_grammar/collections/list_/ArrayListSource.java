package com.banmao.advanced_grammar.collections.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/13 下午1:48
 * @description
 */
public class ArrayListSource {

    public static void main(String[] args) {

        // idea怎么进入jdk源码？
        // 方案1：强制进去源码：alt + shift + F7
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }

        list.add(100);
        list.add(200);
        list.add(null);
    }
}