package com.banmao.advanced_grammar.reflect_.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/4 下午8:08
 * @description
 */
public class LoadCatReflect {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1、记载类
        Class<?> classfullpath = Class.forName(getValue("classfullpath"));

        Object o = classfullpath.newInstance();
        System.out.println(o.getClass());

        // 调用方法
        Method methodName = classfullpath.getMethod(getValue("methodName"));
        methodName.invoke(o);
    }

    public static String getValue(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(
                "/Users/cao/Documents/workspace/java-code-examples/javase/src/main/java/com/banmao/advanced_grammar/reflect_/example/re.properties"));
        return properties.getProperty(key);
    }
}