package com.banmao.advanced_grammar.multithreading.method;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午3:13
 * @description
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        // 测试相关的方法
        T t = new T();
        t.setName("banmao");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start(); // 启动子线程
        System.out.println(t.getName());


        // 主线程打印5个hi，就中断子线程
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "say hi");
        }
        t.interrupt(); // 提前中断子线程的休眠
    }

}

class T extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "吃包子～～～" + i);
        }

        System.out.println(Thread.currentThread().getName() + "休眠中～～～");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // 当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
            System.out.println(Thread.currentThread().getName() + "线程被interrupt了");
        }
    }
}