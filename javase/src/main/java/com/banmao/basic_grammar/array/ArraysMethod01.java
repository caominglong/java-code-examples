package com.banmao.basic_grammar.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/3 下午9:04
 * @description
 */
public class ArraysMethod01 {

    public static void main(String[] args) {

        Integer[] integers = {1, 20, 99};

        System.out.println(Arrays.toString(integers));

        // 排序
        Integer[] arr = {1, -1, 33, 55, 22};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(arr));
    }
}