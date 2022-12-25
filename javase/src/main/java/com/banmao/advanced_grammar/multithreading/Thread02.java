package com.banmao.advanced_grammar.multithreading;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 上午11:37
 * @description 由Runnable的方式来开发线程
 */
public class Thread02 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.start(); // 这里不能调用start
        // 所以先将dog放入到Thread中，然后调用start()方法
        // 使用了代理模式（静态代理）
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while(true) {
            System.out.println("小狗汪汪叫..." + (count++) + "," + Thread.currentThread().getName());
            // 休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 通过ThreadProxy的start能力来代理Runnable
class ThreadProxy implements Runnable {

    private Runnable target = null;// 类型是Runnable接口

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
    // 把这个类当作一个Thread的代理

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();
    }

    private void start0() {
        run();
    }
}