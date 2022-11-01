package com.banmao.basic_grammar.basic_oop.internal_class;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午1:55
 * @description 局部内部类
 */
public class LocalInnerClass {

    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode：" + outer02.hashCode());
    }

}

class Outer02 {
    private int n1 = 10;

    private void m2() {
        System.out.println("Outer02 方法m2");
    }

    public void m1() {
        // 局部内部类定义在外部类的局部位置，通常在方法中
        class Inner02 {
            private int n1 = 800;

            // 可以直接访问外部类的所有成员，包括私有的
            public void f1() {
                // Outer02.this理解成外部类的一个对象，即哪个对象调用了m1方法，即Outer02.this指向谁
                System.out.println("n1=" + n1 + "外部类的n1:" + Outer02.this.n1);
                System.out.println("Outer02.this hashcode = " + Outer02.this.hashCode());
                m2();
            }
        }

        class Inner03 extends Inner02 {

        }

        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}