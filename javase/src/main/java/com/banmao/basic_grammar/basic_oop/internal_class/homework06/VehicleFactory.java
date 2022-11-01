package com.banmao.basic_grammar.basic_oop.internal_class.homework06;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午9:02
 * @description 交通工具工厂类
 */
public class VehicleFactory {

    // 优化点：可以将Horse设计成单例模式，因为骑马只用一匹马就行了
    private static final Horse horse = new Horse();

    // 构造方法私有化
    private VehicleFactory() {}

    // 这里方法里面不涉及到VehicleFactory的一些成员
    // 所以定义为static方法
    public static Horse getHorseInstance() {
        return horse;
    }

    public static Boat getBoatInstance() {
        return new Boat();
    }
}