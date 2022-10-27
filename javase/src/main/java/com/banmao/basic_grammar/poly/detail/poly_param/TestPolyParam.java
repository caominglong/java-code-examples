package com.banmao.basic_grammar.poly.detail.poly_param;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/25 下午8:09
 * @description
 */
public class TestPolyParam {

    public static void main(String[] args) {
        Worker tom = new Worker("tom", 2500);
        Manager milan = new Manager(200000,"milan", 5000);

        TestPolyParam testPolyParam = new TestPolyParam();
        testPolyParam.showEmpAnnual(tom);
        testPolyParam.showEmpAnnual(milan);

        testPolyParam.testWork(tom);
        testPolyParam.testWork(milan);
    }

    // 实现获取任何员工的工资
    public void showEmpAnnual(Employee e) {
        System.out.println(e.calculateAnnual());
    }

    public void testWork(Employee employee) {
        // 向下转型
        if (employee instanceof Worker) {
            ((Worker) employee).work();
        } else if (employee instanceof Manager) {
            ((Manager) employee).manage();
        } else {
            System.out.println("......");
        }
    }
}