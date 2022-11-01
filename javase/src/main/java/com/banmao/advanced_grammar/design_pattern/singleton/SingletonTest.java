package com.banmao.advanced_grammar.design_pattern.singleton;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/29 下午9:16
 * @description
 */
public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("饿汉式测试==============");
        SingletonHungryMan singletonHungryMan1 = SingletonHungryMan.getSingletonHungryMan();
        SingletonHungryMan singletonHungryMan2 = SingletonHungryMan.getSingletonHungryMan();
        System.out.println(singletonHungryMan1 == singletonHungryMan2);
        System.out.println("懒汉式测试==============");

        SingletonLazybones singletonLazybones1 = SingletonLazybones.getSingletonLazybones();
        SingletonLazybones singletonLazybones2 = SingletonLazybones.getSingletonLazybones();
        System.out.println(singletonLazybones1 == singletonLazybones2);
    }
}