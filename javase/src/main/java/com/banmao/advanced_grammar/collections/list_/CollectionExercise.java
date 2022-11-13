package com.banmao.advanced_grammar.collections.list_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/11 下午7:47
 * @description
 */
public class CollectionExercise  {

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        ((ArrayList) collection).add(new Dog("dog1", 10));
        ((ArrayList) collection).add(new Dog("dog2", 12));
        ((ArrayList) collection).add(new Dog("dog3", 14));

        // 1、迭代器遍历
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("next=" + next);
        }

        //2、增强for遍历
        for (Object o : collection) {
            System.out.println("o=" + o);
        }
    }

}

class Dog {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}