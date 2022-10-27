package com.banmao.basic_grammar.poly.detail.poly_param;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/25 下午8:07
 * @description 经理
 */
public class Manager extends Employee {

    // 奖金
    private double bonus;

    public Manager(double bonus, String name, double annual) {
        super(name, annual);
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("经理：" + super.getName() + "在管理工作");
    }

    @Override
    public Double calculateAnnual() {
        return super.calculateAnnual() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}