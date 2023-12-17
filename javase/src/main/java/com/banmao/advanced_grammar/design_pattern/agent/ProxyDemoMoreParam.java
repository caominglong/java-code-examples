package com.banmao.advanced_grammar.design_pattern.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/3/31 下午8:17
 * @description 代理类 (代理方法具有更多参数)
 */
public class ProxyDemoMoreParam {

    public static void main(String[] args) {

        Student3 xiaoming = new Student3("小明");

        InvocationHandler invocationHandler = new MyInvocationHandler3(xiaoming);
        Person3 person3 = (Person3) Proxy.newProxyInstance(Person3.class.getClassLoader(),
                new Class[]{Person3.class}, invocationHandler);
        String sign = "签名";
        Money money = new Money(200, "小明");
        person3.giveMoney(sign, money);
    }
}

class MyInvocationHandler3<T> implements InvocationHandler {

    T entity;

    public MyInvocationHandler3(T entity) {
        this.entity = entity;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理方法被调用");
        System.out.println(Arrays.toString(args));
        System.out.println(args[1]);
        Object invoke = method.invoke(entity, args);
        System.out.println(invoke);
        return invoke;
    }
}

interface Person3 {

    /**
     * 上交班费
     * @param sign 签名
     */
    void giveMoney(String sign, Money money);
}


class Student3 implements Person3 {

    private String name;

    public Student3(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney(String sign, Money money) {

        try {
            // 假设数钱花了1s
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "上交班费50元");
    }
}

class Money {

    public Money(int total, String name) {
        this.total = total;
        this.name = name;
    }

    // 总金额
    private int total;
    // 交钱的人的姓名
    private String name;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Money{" +
                "total=" + total +
                ", name='" + name + '\'' +
                '}';
    }
}
