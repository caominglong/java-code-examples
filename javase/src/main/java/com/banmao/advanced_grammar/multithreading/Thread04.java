package com.banmao.advanced_grammar.multithreading;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午2:30
 * @description 使用多线程模拟3个窗口同时售票
 */
public class Thread04 {

    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start(); // 启动售票窗口
//        sellTicket02.start(); // 启动售票窗口
//        sellTicket03.start(); // 启动售票窗口

        // 使用接口的方式
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();

        // 问题：出现了超卖的现象
        // 原因解析：

    }

}

// 使用Thread方式

class SellTicket01 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        System.out.println("卖票");
        while (true) {
            if (ticket <= 0) {
                System.out.println("售票结束");
                break;
            }

            // 休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口：" + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--ticket));
        }

    }
}

class SellTicket02 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        System.out.println("卖票");
        while (true) {
            if (ticket <= 0) {
                System.out.println("售票结束");
                break;
            }

            // 休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口：" + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--ticket));
        }
    }
}