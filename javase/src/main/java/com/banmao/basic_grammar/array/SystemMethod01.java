package com.banmao.basic_grammar.array;

import java.util.Arrays;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/3 下午10:27
 * @description
 */
public class SystemMethod01 {

    public static void main(String[] args) {

        // 系统退出
        System.out.println("hhh");
        // 后面的参数，代表程序退出的状态
        // System.exit(0);
        System.out.println("afff");

        // 复制
        Integer[] integers = {1, 3, 44, 5, 6, 32};
        Integer[] dest = new Integer[3];
        // 参数说明：
        // 1、第一个参数：源数组
        // 2、从源数组的哪个索引进行拷贝
        // 3、目标拷贝数组
        // 4、把源数组的数据拷贝到目标数组的哪个索引（开始索引）
        // 5、从源数组拷贝多少个数组数据到目标数组
        // System.arraycopy(integers, 0, dest, 0, integers.length);
        System.out.println(Arrays.toString(dest));

        // 返回系统当前的毫秒数
        long l = System.currentTimeMillis();
        System.out.println("当前毫秒值：" + l);


    }
}