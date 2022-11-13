package com.banmao.advanced_grammar.collections.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/13 下午3:47
 * @description ArrayList的最大长度是多少？
 */
public class ArrayListMaxValue {

    public static void main(String[] args) {

        // 首先来看Object数组的最大长度
        // 涉及的知识：java中的一个对象在内存中怎么表示？
        // 分为3部分：
        // 1、对象头（Header）=> 分为3部分。
        //     MarkWord：用于存储对象运行时的数据，比如HashCode、锁状态标志、GC分代年龄等。在64位系统下占8字节
        //     元数据指针：对象指向它的类元素的指针，虚拟机通过这个指针来确定这个对象是哪一个类的实例。（开启指针压缩的话占4字节，否则8字节）
        //     数组长度（数组专用，数组对象才有），占4字节
        // 2、实例数据（Instance Data）
        // 3、对齐填充（Padding）：java对象默认是按8字节填充，也就是说最后的字节大小必须是8字节的倍数。如果不是，则进行补充。
        // Object[] object = new Object[2147480000]; // 会报堆内存溢出。

        // List list = new ArrayList(214748164); // 不会报错
        // 总结：数组的默认大小为Integer.MAX_VALUE,但会收到堆内存大小的限制。所以不能确定最大能创建多少长度的数组
        // list.add(1);
    }
}