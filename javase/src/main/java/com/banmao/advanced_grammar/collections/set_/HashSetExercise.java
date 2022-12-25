package com.banmao.advanced_grammar.collections.set_;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/19 下午8:17
 * @description
 */
public class HashSetExercise {

    public static void main(String[] args) {
        // 定义Employee放入HashSet中，当name和age的值相同时，认为是相同员工，不能添加到HashSet集合中
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("张三", 100));
        hashSet.add(new Employee("李四", 200));
        hashSet.add(new Employee("张三", 100));

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Employee employee = (Employee) next;
            System.out.println("名字为：" + employee.getName() + ",年龄为：" + employee.getAge());
        }

    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.age = age;
        this.name = name;
    }

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

    @Override
    public int hashCode() {
        // 让相同名字与相同年龄的hashcode值相同
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        // 让相同名字与年龄的对象相同
        Employee employee = (Employee) obj;
        if (this.name.equals(employee.name) && this.age == employee.age) {
            return true;
        }
        return false;
    }
}