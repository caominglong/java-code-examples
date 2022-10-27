package com.banmao.basic_grammar.functions;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/22 下午12:47
 * @description 可变参数
 */
public class VarParameters {

    public static void main(String[] args) {
        HspMethod hspMethod = new HspMethod();

    }
}

class HspMethod {

    // 名称相同、功能相同，但是参数个数不同的函数，可以使用可变参数
    // int... nums可以接收0-多个参数
    // 使用可变参数时，可以当作数组来使用
    public int sum(int... nums) {
        System.out.println(nums.length);
        int res = 0;
        for(int val : nums) {
            res += val;
        }
        return res;
    }
}