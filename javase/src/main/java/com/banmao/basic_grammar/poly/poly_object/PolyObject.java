package com.banmao.basic_grammar.poly.poly_object;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/24 下午9:47
 * @description
 */
public class PolyObject {

    public static void main(String[] args) {
        // 体验对象多态特点
        Animal animal = new Dog();
        animal.cry(); // 执行到该行时，animal的运行类型为dog，这时的cry就是dog的cry()

        animal = new Cat();
        animal.cry(); // 小猫喵喵叫
    }
}