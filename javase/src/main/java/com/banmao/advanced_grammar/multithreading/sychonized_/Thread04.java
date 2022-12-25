package com.banmao.advanced_grammar.multithreading.sychonized_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午2:30
 * @description 使用多线程模拟3个窗口同时售票（使用synchronized）
 */
public class Thread04 {

    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();

        sellTicket01.start(); // 启动售票窗口
        sellTicket02.start(); // 启动售票窗口
        sellTicket03.start(); // 启动售票窗口


    }

}

// 使用Thread方式

class SellTicket01 extends Thread {

    private static int ticket = 100;
    // 因为上面调用时，启动的是三个对象，所以下面的需要用一个共享对象作为三个线程的锁，而不是将
    // synchronized写在方法上，这样锁住的只是调用方法的对象而已
    public static Object object = new Object();
    public static boolean loop = true;

    @Override
    public void run() {
        System.out.println("卖票");
        while (loop) {
            sell();
        }

    }

    private void sell() {
        synchronized (object) {
            if (ticket <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
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