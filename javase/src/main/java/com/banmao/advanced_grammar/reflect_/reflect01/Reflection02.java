package com.banmao.advanced_grammar.reflect_.reflect01;

import com.banmao.advanced_grammar.reflect_.example.Cat;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午8:36
 * @description 测试反射调用的性能
 */
public class Reflection02 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {

    }

    @Test
    public void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法来调用。话费时间：" + (end - start));
    }

    @Test
    public void m2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        long start = System.currentTimeMillis();
        Class<?> aClass = Class.forName("com.banmao.advanced_grammar.reflect_.example.Cat");
        Method h1 = aClass.getMethod("hi");
        for (int i = 0; i < 90000000; i++) {
            h1.invoke(aClass.newInstance());
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法来调用。话费时间：" + (end - start));
    }

}