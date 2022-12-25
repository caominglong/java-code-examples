package com.banmao.advanced_grammar.collections.map;

import java.util.HashMap;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/22 下午8:27
 * @description
 */
public class Map_ {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        // hashMap.put("no1", "1111");

        // hashMap.get("no1");

        for (int i = 0; i <= 12; i++) {
            hashMap.put(new A(), "hello");
        }

        for (int i = 0; i <= 8; i++) {
            hashMap.put(new B(), "hello");
        }

//        final Node<K,V> getNode(int hash, Object key) {
//            Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
//            if ((tab = table) != null && (n = tab.length) > 0 &&
//                    (first = tab[(n - 1) & hash]) != null) {
//                if (first.hash == hash && // always check first node
//                        ((k = first.key) == key || (key != null && key.equals(k))))
//                    return first;
//                if ((e = first.next) != null) {
//                    if (first instanceof TreeNode)
//                        return ((TreeNode<K,V>)first).getTreeNode(hash, key);
//                    do {
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k))))
//                            return e;
//                    } while ((e = e.next) != null);
//                }
//            }
//            return null;
//        }
    }
}

class A {
    private String name;

    @Override
    public int hashCode() {
        return 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class B {
    private String name;

    @Override
    public int hashCode() {
        return 200;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}