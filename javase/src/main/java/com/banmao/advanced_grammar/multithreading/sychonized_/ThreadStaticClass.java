package com.banmao.advanced_grammar.multithreading.sychonized_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午8:28
 * @description
 */
public class ThreadStaticClass {
}

class SellTicket03 implements Runnable {

    @Override
    public void run() {
        m1();
        m2();
    }

    // synchronized需要加在静态方法上，锁住的是当前类本身：类.class
    private synchronized static void m1() {
        System.out.println("m1");
    }

    private static void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }
}