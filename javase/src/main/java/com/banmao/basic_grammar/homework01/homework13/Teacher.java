package com.banmao.basic_grammar.homework01.homework13;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 上午7:43
 * @description
 */
public class Teacher extends Person{

    private int workAge;

    public Teacher(String name, char sex, int age, int workAge, String hobby) {
        super(name, sex, age, hobby);
        this.workAge = workAge;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public void teach() {
        System.out.println("我承若，我会好好教学");
    }

}