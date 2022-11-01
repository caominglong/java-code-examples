package com.banmao.advanced_grammar.design_pattern.singleton;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 下午9:02
 * @description 单例设计模式（饿汉式）
 * 设计思想：利用静态属性在类加载时的初始化，创建一个单例对象，供外部调用。
 * 为什么称之为饿汉：因为对象在类加载时，就已经实例化了，静态工厂方法此时可能还未被使用。
 */
public class SingletonHungryMan {

    // 静态属性初始化时，实例化一个对象，注意：必须给private权限
    private static SingletonHungryMan singletonHungryMan = new SingletonHungryMan();

    // 构造方法私有化
    private SingletonHungryMan() {

    }

    // 提供一个单实例的访问（称之为静态工厂方法）
    public static SingletonHungryMan getSingletonHungryMan() {
        return singletonHungryMan;
    }
}