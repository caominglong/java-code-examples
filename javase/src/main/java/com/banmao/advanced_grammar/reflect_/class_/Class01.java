package com.banmao.advanced_grammar.reflect_.class_;

import com.banmao.advanced_grammar.reflect_.example.Cat;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午9:01
 * @description
 */
public class Class01 {

    public static void main(String[] args) throws ClassNotFoundException {
        //Class类对象不是new出来的，而是系统创建的
        // 传统方式
//        public Class<?> loadClass(String name) throws ClassNotFoundException {
//            return loadClass(name, false);
//        }
        // Cat cat = new Cat();
        // 反射方式。仍然是通过loadClass方式
        Class<?> aClass = Class.forName("com.banmao.advanced_grammar.reflect_.example.Cat");

        System.out.println(aClass);
        BB cat = new CC();
        System.out.println(cat.getClass());
        System.out.println(cat);

    }
}

class BB {

}

class CC extends BB {}