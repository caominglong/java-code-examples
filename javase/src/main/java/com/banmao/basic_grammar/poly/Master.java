package com.banmao.basic_grammar.poly;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/24 下午9:25
 * @description
 */
public class Master {

    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 使用多态机制，可以统一解决主人喂食物的问题
    // animal是编译类型，可以接收其子类的所有运行类型
    public void feed(Animal animal, Food food) {
        System.out.println("主人" + name + "给" + animal.getName() + "吃" + food.getName());
    }

    // 主人给小狗喂食
    public void feed(Dog dog, Bone bone) {
        System.out.println("主人" + name + "给" + dog.getName() + "吃" + bone.getName());
    }

    // 主人给小猫喂食
    public void feed(Cat cat, Fish fish) {
        System.out.println("主人" + name + "给" + cat.getName() + "吃" + fish.getName());
    }

    // 如果动物很多，食物很多
    // feed方法将会很多，不利于管理和维护

}