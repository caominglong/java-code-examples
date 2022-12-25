package com.banmao.advanced_grammar.collections.homework;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/26 下午1:53
 * @description
 */
public class HomeWork06 {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person2 person1 = new Person2(1001, "AA");
        Person2 person2 = new Person2(1002, "BB");
        hashSet.add(person1);
        hashSet.add(person2);
        person1.setName("CC");
        // 这里将无法删除person1，因为已经将person1的name改变了，那么它的重新计算的hash值也是会变的
        hashSet.remove(person1);
        System.out.println(hashSet);
    }
}

class Person2 {

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id &&
                Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}