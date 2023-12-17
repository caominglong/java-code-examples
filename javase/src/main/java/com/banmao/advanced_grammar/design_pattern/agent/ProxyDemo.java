package com.banmao.advanced_grammar.design_pattern.agent;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/3/31 下午8:17
 * @description 代理类
 */
public class ProxyDemo {

    public static void main(String[] args) {

        Student xiaoming = new Student("小明");

        InvocationHandler invocationHandler = new MyInvocationHandler<Student>(xiaoming);
        Person o = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class[]{Person.class}, invocationHandler);
        o.giveMoney();

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "/Users/cao/Downloads/StuProxy.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}

class MyInvocationHandler<T> implements InvocationHandler {

    T entity;

    public MyInvocationHandler(T entity) {
        this.entity = entity;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理方法被调用");
        System.out.println(args);
        Object invoke = method.invoke(entity, args);
        System.out.println(invoke);
        return invoke;
    }
}

interface Person {

    /**
     * 上交班费
     */
    void giveMoney();
}


class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {

        try {
            // 假设数钱花了1s
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "上交班费50元");
    }
}
