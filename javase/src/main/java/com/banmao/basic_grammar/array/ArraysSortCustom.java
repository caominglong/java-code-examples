package com.banmao.basic_grammar.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/3 下午9:28
 * @description 自定义的排序
 */
public class ArraysSortCustom {

    public static void main(String[] args) {
        int[] arr = {1, -1, 44, 22, 42};
        // 匿名内部类

        bubble(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 编程思想：面向接口编程
     * 冒泡排序
     * @param arr
     */
    public static void bubble(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int compare = c.compare(arr[j], arr[j + 1]);
                // System.out.println(compare);
                if (compare > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}