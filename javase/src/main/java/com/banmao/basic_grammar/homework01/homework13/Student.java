package com.banmao.basic_grammar.homework01.homework13;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 上午7:33
 * @description
 */
public class Student extends Person{

    private int stu_id;

    public Student(String name, char sex, int age, int stu_id, String hobby) {
        super(name, sex, age, hobby);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承若，我会好好学习");
    }

}