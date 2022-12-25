package com.banmao.advanced_grammar.multithreading.deadlock_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午8:36
 * @description
 */
public class DeadLock {

    public static void main(String[] args) {
        // 默认死锁现象
        DeadLockDemo deadLockDemo = new DeadLockDemo(true);
        deadLockDemo.setName("A线程");
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(false);
        deadLockDemo1.setName("B线程");
        deadLockDemo.start();
        deadLockDemo1.start();
    }
}

class DeadLockDemo extends Thread {

    static Object o1 = new Object();
    static Object o2 = new Object();

    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        // 业务逻辑的分析：
        // 1、如果flag为T，线程A会先得到/持有o1对象锁
        // 2、如果线程A拿不到对象锁o2，就会Blocked
        // 2、如果flag为F，线程B会先持有得到o2对象锁，然后尝试去获取o1对象锁
        // 2、如果线程B拿不到对象锁o1，就会Blocked
        if (flag) {
            synchronized (o1) { // 对象互斥锁
                System.out.println(Thread.currentThread().getName() + "进入o1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入o2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}