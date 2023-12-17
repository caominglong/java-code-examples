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
public class ProxyDemo2 {

    public static void main(String[] args) {

        Student2 xiaoming = new Student2("小明");

        InvocationHandler invocationHandler = new MyInvocationHandler2(xiaoming);
//        Proxy.newProxyInstance(Person2.class.getClassLoader(),
//                new Class[]{Person2.class, Son.class}, invocationHandler);
        // o.getMoneyFromMom()

        Object o1 = Proxy.newProxyInstance(Person2.class.getClassLoader(),
                new Class[]{Person2.class, Son.class}, invocationHandler);
        Person2 person2 = (Person2) o1;
        person2.giveMoney();
        Son son = (Son) o1;
        son.getMoneyFromMom();

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student2.class.getInterfaces());
        String path = "/Users/cao/Downloads/StuProxy2.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}

class MyInvocationHandler2<T> implements InvocationHandler {

    T entity;

    public MyInvocationHandler2(T entity) {
        this.entity = entity;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass());
        System.out.println("代理方法被调用");
        System.out.println(args);
        Object invoke = method.invoke(entity, args);
        System.out.println(invoke);
        return invoke;
    }
}

interface Person2 {

    /**
     * 上交班费
     */
    void giveMoney();
}

interface Son {

    /**
     * 从妈妈那拿钱
     */
    void getMoneyFromMom();
}


class Student2 implements Person2, Son{

    private String name;

    public Student2(String name) {
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

    @Override
    public void getMoneyFromMom() {
        try {
            // 假设妈妈数钱花了1s
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "从妈妈那里拿了100");
    }
}
