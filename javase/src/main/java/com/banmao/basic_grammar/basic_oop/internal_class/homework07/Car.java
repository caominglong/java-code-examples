package com.banmao.basic_grammar.basic_oop.internal_class.homework07;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午9:26
 * @description
 */
public class Car {

    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public class Air {

        // 吹风的功能
        public void flow() {
            // 这里可以直接用temperature，因为内部类没有与外部类同名的属性
            if (Car.this.temperature > 40) {
                System.out.println("吹冷气");
            } else if (Car.this.temperature < 0) {
                System.out.println("吹暖气");
            } else {
                System.out.println("空调关闭中");
            }
        }
    }

    public Air getAirInstance() {
        return new Air();
    }
}