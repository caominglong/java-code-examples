package com.banmao.basic_grammar.basic_oop;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/22 下午6:21
 * @description this关键字
 */
public class This01 {

    public static void main(String[] args) {
        Dog dog = new Dog("大壮", 3);
        dog.info();
    }
}

class Dog {
    String name;
    int age;
    public Dog(String dName, int dAge) {
        // 如果需要将dName修改为name，那么使用this关键字
        name = dName;
        age = dAge;
    }

    public void info() {
        System.out.print(name + "\t" + age + "\t");
    }

}