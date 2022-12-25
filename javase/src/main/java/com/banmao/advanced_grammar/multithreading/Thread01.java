package com.banmao.advanced_grammar.multithreading;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 上午10:36
 * @description 线程基本使用（通过继承Thread类进行创建线程）
 */
public class Thread01 {

    public static void main(String[] args) {
        // 创建一个cat对象，可以当作一个线程来使用
        Cat cat = new Cat();
        // 1、运行线程,如果这里写成cat.run()。则是main线程来执行run方法，则等run方法执行完之后，才会继续执行下面代码
        // 2、start方法调用start0方法后，该线程并不一定会立马执行，只是将线程变成了可运行状态。具体什么时候执行，取决于CPU，由CPU统一调度。
        // start0是本地方法，是JVM调用，由C/C++实现。
        cat.start();

        // 当main线程启动一个子线程Thread-0，主线程不会阻塞，会继续执行

        System.out.println("主线程继续执行");
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName() + ",主线程 i=" + i);
            // 让主线程休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

// 1、当一个类继承了Thread类，该类就可以当作线程使用
class Cat extends Thread {

    int times = 0;

    @Override
    public void run() {
        // 重写run方法。写上自己的业务逻辑
        // 该线程每隔1s，在控制台输出"喵喵，我是小猫咪"
        while (true) {
            System.out.println("喵喵，我是小猫咪！" + (++times));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times >= 80) {
                System.out.println("退出循环");
                break;
            }
        }

    }

}