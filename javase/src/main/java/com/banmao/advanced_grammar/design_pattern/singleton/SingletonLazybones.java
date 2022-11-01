package com.banmao.advanced_grammar.design_pattern.singleton;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 下午9:12
 * @description 单例设计模式（懒汉式）
 *  设计思想：当真正使用静态工厂时，才进行实例化对象，并提供外部调用
 *  为什么称之为懒汉：因为只有你真正需要对象时，我才提供一个单例给你用
 *  注意事项：以下的懒汉式的静态工厂方法有并发问题。
 */
public class SingletonLazybones {

    // 静态属性初始化时，实例化一个对象，注意：必须给private权限
    private static SingletonLazybones singletonLazybones;

    // 构造方法私有化
    private SingletonLazybones() {

    }

    // 提供一个单实例的访问（称之为静态工厂方法）
    public static SingletonLazybones getSingletonLazybones() {
        if (singletonLazybones == null) {
            singletonLazybones = new SingletonLazybones();
        }
        return singletonLazybones;
    }
}