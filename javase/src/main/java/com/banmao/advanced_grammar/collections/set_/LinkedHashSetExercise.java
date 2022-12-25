package com.banmao.advanced_grammar.collections.set_;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/20 下午8:00
 * @description linkedHashSet练习
 */
public class LinkedHashSetExercise {

    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(new Class1("test1"));
        linkedHashSet.add(new Class1("test2"));
        linkedHashSet.add(new Class2("class2test1"));
        linkedHashSet.add(new Class2("class2test2"));



        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        String[] ss = new String[2];
        ss[0] = "";

        Class1 class1 = new Class1("222");
        Class1.InnerClass2 innerClass2 = class1.new InnerClass2();
    }
}

class Class1 {
    private String name;

    public Class1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "Class1{" +
                "name='" + name + '\'' +
                '}';
    }

    public class InnerClass2 {
        public String key = "100";
        private String name2;

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }
    }
}

class Class2 {
    private String name;

    public Class2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 200;
    }

    @Override
    public String toString() {
        return "Class2{" +
                "name='" + name + '\'' +
                '}';
    }
}