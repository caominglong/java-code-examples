package com.banmao.basic_grammar.basic_oop.internal_class;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午3:29
 * @description 匿名内部类使用场景：当作实参进行传递
 */
public class AnonymousInnerClassExercise {

    public static void main(String[] args) {
        // 匿名内部类可以当作实参直接传递
        f1(new AA() {
            @Override
            public void show() {
                System.out.println("这是一副名画...");
            }
        });
    }

    // 静态方法
    public static void f1(AA aa) {
        aa.show();
    }
}

interface AA {
    void show();
}