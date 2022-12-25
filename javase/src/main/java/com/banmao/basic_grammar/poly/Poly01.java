package com.banmao.basic_grammar.poly;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/24 下午9:23
 * @description 多态
 */
public class Poly01 {

    public static void main(String[] args) {
        Master tom = new Master("汤姆");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        tom.feed(dog, bone);

        Cat cat = new Cat("小花猫");
        Fish fish = new Fish("鲫鱼");
        tom.feed(cat, fish);
    }
}
