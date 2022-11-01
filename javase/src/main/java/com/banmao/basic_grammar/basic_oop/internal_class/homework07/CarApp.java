package com.banmao.basic_grammar.basic_oop.internal_class.homework07;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午9:31
 * @description
 */
public class CarApp {

    public static void main(String[] args) {
//        Car car = new Car(50);
//        Car.Air air = car.new Air();
//        air.flow();
//
//        Car car2 = new Car(-1);
//        Car.Air air2 = car2.new Air();
//        air2.flow();
//
//        Car car3 = new Car(10);
//        Car.Air air4 = car3.new Air();
//        air4.flow();

        Car car = new Car(50);
        Car.Air airInstance = car.getAirInstance();
        airInstance.flow();
    }
}