package com.banmao.algorithm.sort;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/19 下午9:21
 * @description 冒泡排序
 * 原理：从第一个元素开始，逐步的与后面的元素进行比较，将大的元素向后移动，并完成整个排序过程。形象的称之为冒泡
 */
public class BubbleSort {

    /**
     *
     * @param originArray 原数组
     * @return 返回排序后的新数组
     */
    private static int[] bubbleSort(int[] originArray) {
        // 思路分析：
        // 1、假设原数组为int[] a = {2，1，5，6，2，3}。
        // 第一次进行冒泡，将比较（数组长度 - 1次）
        // 第二次进行冒泡，将比较（数组长度 - 2次）
        // 第三次进行冒泡，将比较（数组长度 - 3次）
        // 第n次进行冒泡，将比较（数组长度 - n次）
        // ...
        // 可以得出结论，需要两层循环。
        // 外层循环总共需要进行（数组长度-1）次
        // 内层循环的比较次数，就是（数组长度-i）次
        int[] arr1 = originArray;
        for (int i = 1; i < arr1.length; i++) {
            for(int j = 0; j < arr1.length - i; j++) {
                if (arr1[j] >= arr1[j+1]) {
                    // 交换元素的位置
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }
            }
        }
        return arr1;
    }

    /**
     *
     * @param originArray 原数组
     * @return 返回排序后的新数组
     */
    private static int[] bubbleSortOptimize(int[] originArray) {
        // 思路分析：
        // 优化：当一次都没有交换时（也就是本来数组就有序时），此时执行终止循环即可

        int[] arr1 = originArray;
        boolean isExchange = false;
        for (int i = 1; i < arr1.length; i++) {
            for(int j = 0; j < arr1.length - i; j++) {
                if (arr1[j] >= arr1[j+1]) {
                    // 交换元素的位置
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                    // 将交换标志位改为true
                    isExchange = true;
                }
            }
            if (!isExchange) {
                System.out.println("未交换，直接结束！");
                break;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,1,5,6,2,3};
        int[] arr1Sorted = bubbleSort(arr1);
        for (int i : arr1Sorted) {
            System.out.println("元素为：" + i);
        }

        // 提供一个已经有序的数组，使用优化后的冒泡排序
        int[] arr2 = {1,2,3,4,6,7};
        int[] arr2Sorted = bubbleSortOptimize(arr2);
        for (int i : arr2Sorted) {
            System.out.println("元素为：" + i);
        }
    }
}