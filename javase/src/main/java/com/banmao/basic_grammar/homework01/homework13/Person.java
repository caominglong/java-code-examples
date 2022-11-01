package com.banmao.basic_grammar.homework01.homework13;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 上午7:45
 * @description
 */
public class Person {

    private String name;
    private char sex;
    private int age;
    // 爱好
    private String hobby;

    public Person(String name, char sex, int age, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hobby = hobby;
    }

    public void play() {
        System.out.println(getName() + "爱玩" + getHobby());
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}