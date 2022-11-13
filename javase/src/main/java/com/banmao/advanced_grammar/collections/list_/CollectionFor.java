package com.banmao.advanced_grammar.collections.list_;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/11 下午7:42
 * @description 增强for循环
 */
public class CollectionFor {

    public static void main(String[] args) {
        Collection col = new ArrayList();
        ((ArrayList) col).add(new Book("book1", "111", 100));
        ((ArrayList) col).add(new Book("book2", "222", 200));
        ((ArrayList) col).add(new Book("book3", "333", 300));
        
        // 使用增强for循环
        // 增强for，底层仍然是迭代器
        for (Object o : col) {
            System.out.println("o=" + o);
        }
    }
}