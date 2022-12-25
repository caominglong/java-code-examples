package com.banmao.advanced_grammar.reflect_.reflect01;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午8:36
 * @description
 */
public class Reflection01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        // 1、记载类
        Class<?> classfullpath = Class.forName(getValue("classfullpath"));

        Object o = classfullpath.newInstance();
        System.out.println(o.getClass());

        // getField不能得到私有的属性
        // Field name = classfullpath.getField("name");
        // 得到无参构造器
        Constructor<?> constructor = classfullpath.getConstructor();
        System.out.println(constructor);
        // 得到有参构造器
        Constructor<?> constructor2 = classfullpath.getConstructor(String.class);
        System.out.println(constructor2);
    }

    public static String getValue(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(
                "/Users/cao/Documents/workspace/java-code-examples/javase/src/main/java/com/banmao/advanced_grammar/reflect_/example/re.properties"));
        return properties.getProperty(key);
    }
}