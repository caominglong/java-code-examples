package com.banmao.basic_grammar.basic_oop.final_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 下午9:38
 * @description final和static搭配使用，效率更高，底层编译器做了优化处理
 */
public class FinalWithStatic {

    public static final String HHH_GOOD = "初始化静态常量";

    static {
        System.out.println("静态代码块初始化");
    }
}