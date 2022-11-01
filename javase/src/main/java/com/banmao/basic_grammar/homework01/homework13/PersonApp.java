package com.banmao.basic_grammar.homework01.homework13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 上午7:53
 * @description
 */
public class PersonApp {

    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Student("小名", '男', 17, 12222, "足球");
        people[1] = new Student("小花", '女', 13, 12223, "足球");
        people[2] = new Teacher("老王", '男', 40, 12, "象棋");
        people[3] = new Teacher("老齐", '女', 45, 13, "象棋");
        // 按照年龄从高到低排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) {
                // o1大于o2，返回正整数
                return o1.getAge() - o2.getAge();
            } else if (o1.getAge() < o2.getAge()) {
                // o1小于o2，返回负整数
                return o1.getAge() - o2.getAge();
            }
            // 否则返回0，表示相等
            return 0;
        });
        for (Person person : people) {
            System.out.println(person.getName() + "," + person.getAge());
        }

        new PersonApp().print(people[0]);
        new PersonApp().print(people[3]);

        people[0].play();
        people[3].play();
    }

    private void print(Person person) {
        if (person instanceof Student) {
            ((Student) person).study();
        }
        if (person instanceof Teacher) {
            ((Teacher) person).teach();
        }
    }

    public void bubbleSort(Person[] people) {
        // 冒泡排序
        for(int i = 0; i < people.length - 1; i++) {
            // 外层只用冒泡，people.length - 1次
            for (int j = 0; j < people.length - 1 - i; j++) {
                // 每次冒泡都选出一个最大数，所以内层比较次数，每次冒泡结束后，都会少一次
                // 所以内层是people.length - 1 - i次
                if (people[j].getAge() < people[j+1].getAge()) {
                    // 从大到小排序
                    // 进行交换对象
                    Person temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }
    }
}