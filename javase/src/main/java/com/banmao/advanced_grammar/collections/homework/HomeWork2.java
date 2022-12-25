package com.banmao.advanced_grammar.collections.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/26 上午11:32
 * @description
 */
public class HomeWork2 {

    public static void main(String[] args) {
        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        List<Car> cars = new ArrayList<>();
        // 添加单个元素
        System.out.println("======添加单个元素======");
        cars.add(car1);
        cars.add(car2);
        printArrayList(cars);
        // 删除car1
        System.out.println("======删除car1======");
        cars.remove(car1);
        printArrayList(cars);

        // 查找元素是否存在
        System.out.println("======查找元素是否存在======");
        if (cars.contains(car2)) {
            System.out.println("======car2存在======");
        }

        // 获取元素个数
        System.out.println("======获取元素个数======");
        System.out.println(cars.size());

        // 判断是否为空
        System.out.println("======判断是否为空======");
        if (!cars.isEmpty()) {
            System.out.println("cars集合不为空");
        }
        // 清空集合
        System.out.println("======清空集合======");
        cars.clear();
        // 添加多个元素
        System.out.println("======添加多个元素======");
        Set<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        cars.addAll(carSet);
        printArrayList(cars);

        // 查找多个元素是否都存在
        System.out.println("======查找多个元素是否都存在======");
        Set<Car> carSet2 = new HashSet<>();
        carSet2.add(car1);
        carSet2.add(car2);
        boolean b = cars.containsAll(carSet2);
        if (b) {
            System.out.println("元素car1与car2都存在于集合cars中");
        }

        // 删除多个元素
        cars.removeAll(carSet2);
        printArrayList(cars);
    }

    public static void printArrayList(List<? extends Car> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Car {

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}