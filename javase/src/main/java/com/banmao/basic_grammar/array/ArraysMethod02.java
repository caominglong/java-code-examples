package com.banmao.basic_grammar.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/3 下午10:02
 * @description
 */
public class ArraysMethod02 {

    public static void main(String[] args) {

        Integer[] integer = {1, 2, 55, 666, 5667};

        // 如果使用二叉查找法，要求该数组有序
        int r = Arrays.binarySearch(integer, 56677);

        // 如果不存在该数组中，返回的是-(low + 1)，代表(该数组所在的位置 + 1)取负数
        System.out.println("查找到的元素为：" + r);


        // 数组赋值
        // 拷贝源数组的newLength元素的长度到新数组中
        // 如果newLength大于源数组的长度，则赋予null
        // 如果拷贝长度小于0，则抛出异常
        Integer[] newArr = Arrays.copyOf(integer, 4);
        System.out.println(Arrays.toString(newArr));

        // 数组的填充
        Integer[] fillArr = new Integer[]{1, 2, 3};
        // 可以理解为替换为所有的元素为99
        Arrays.fill(fillArr, 99);
        System.out.println(Arrays.toString(fillArr));

        // 数组相等比较
        Integer[] integer2 = {1, 2, 55, 666, 5667};
        boolean equals = Arrays.equals(integer, integer2);
        System.out.println("两个数组比较：" + equals);

        // 将数组转为list
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
        System.out.println(integers.toString());

    }
}