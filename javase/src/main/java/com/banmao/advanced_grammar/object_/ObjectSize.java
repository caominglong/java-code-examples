package com.banmao.advanced_grammar.object_;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/13 下午4:51
 * @description java中各对象的大小
 */
public class ObjectSize {

    public static void main(String[] args) {
        // 经过测试，可得出
        // 1、new Object()实例对象占用16个字节（开启指针压缩的话，占用12字节）
        // Object o普通对象指针(引用)占用4个字节
        // Object[]数组对象，占用16个字节，因为数组对象有独有的4字节长度。
        // 所有以下objects对象的字节大小为：16字节 + 100 * 4 = 416字节（因为已经是8的倍数了，所以无须对齐）
        // 此处的100*4 = 100个引用的字节数，每个Object引用占用4个字节。所以等于 100 * 4
        Object[] objects = new Object[100];
        // objects[0] = new Object();
        ClassLayout classLayout = ClassLayout.parseInstance(objects);
        System.out.println(classLayout.toPrintable());
    }
}