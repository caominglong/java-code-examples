package com.banmao.basic_grammar.basic_oop.internal_class.homework06;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午8:53
 * @description 人类
 */
public class Person {

    private String name;

    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    // 一般情况下，用骑马赶路
    public void common() {
        if (vehicles == null || vehicles instanceof Boat) {
            vehicles = VehicleFactory.getHorseInstance();
        }
        vehicles.work();
    }

    // 过河的时候，用划船
    public void crossRiver() {
        if (vehicles == null || vehicles instanceof Horse) {
            vehicles = VehicleFactory.getBoatInstance();
        }
        // 利用船的能力
        vehicles.work();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }
}