package com.banmao.basic_grammar.poly.detail.poly_param;


/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/25 下午8:04
 * @description 普通员工
 */
public class Worker extends Employee {

    public Worker(String name, double annual) {
        super(name, annual);
    }

    public void work() {
        System.out.println("员工:" + getName() + "在干活");
    }

    @Override
    public Double calculateAnnual() {
        return super.calculateAnnual();
    }
}