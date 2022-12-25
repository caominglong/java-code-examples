//package com.banmao.basic_grammar.basic_oop.internal_class;
//
///**
// * @author banmao
// * @version V1.0.0
// * @date 2022/10/30 下午3:47
// * @description
// */
//public class MemberInnerClass {
//
//    public static void main(String[] args) {
//        Outer08 outer08 = new Outer08();
//        //外部其它类访问成员内部类的三种方式
//        // 第一种方式：将Inner08看作对象的一个成员
//        Outer08.Inner08 inner08 = outer08.new Inner08();
//        inner08.say();
//
//        // 第二种方式：在外部类中定义一个方法，可以返回Inner08的对象
//        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
//        inner08Instance.say();
//
//        // 第三种方式：
//        Outer08.Inner08 inner081 = new Outer08().new Inner08();
//    }
//}
//
//class Outer08 {
//    private int n1 = 10;
//    public String name = "张三";
//
//    private void hi() {
//        System.out.println("hi方法");
//    }
//
//    public class Inner08 {
//        private double sal = 99.8;
//        public void say() {
//            System.out.println("n1=" + n1 + ",name=" + name);
//            hi();
//        }
//    }
//
//    public Inner08 getInner08Instance() {
//        return new Inner08();
//    }
//}