package com.banmao.variable;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/22 下午12:58
 * @description 变量作用域
 */
public class Scope01 {
}

class Cat {

    private void cry() {
        // 1、局部变量一般是指在成员方法中定义的变量
        int n = 10;
        String name = "jack";
    }
}