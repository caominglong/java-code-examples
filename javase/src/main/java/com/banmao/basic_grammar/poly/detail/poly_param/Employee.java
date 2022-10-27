package com.banmao.basic_grammar.poly.detail.poly_param;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/25 下午8:02
 * @description
 */
public class Employee {

    private String name;

    private double salary;

    public Employee(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    // 计算年工资
    public Double calculateAnnual() {
        return 12 * salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}