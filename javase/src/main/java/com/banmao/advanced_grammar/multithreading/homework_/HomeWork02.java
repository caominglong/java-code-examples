package com.banmao.advanced_grammar.multithreading.homework_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午9:13
 * @description
 */
public class HomeWork02 {

    public static void main(String[] args) {
        // 两个客户从同一个账户取钱（总额10000）
        // 每次取的钱数从控制台获取，不能出现超取的现象。

        MoneyThread moneyThread2 = new MoneyThread();
        moneyThread2.setName("B客户");
//        moneyThread2.setPriority(Thread.MAX_PRIORITY);
        moneyThread2.start();
        MoneyThread moneyThread1 = new MoneyThread();
        moneyThread1.setName("A客户");
        moneyThread1.start();
    }
}

class MoneyThread extends Thread {

    private static double money = 10000;
    private final static Object object = new Object();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        // 总结：为什么这里不行，因为start()方法调用后，底层的start0方法将会根据操作系统底层来调用线程的run方法
        // 只有run方法执行完毕后，当前线程的锁才会释放。所以这里会一直在循环。
        // 修改方案：
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "进入代码块");
                if (MoneyThread.money <= 0) {
                    System.out.println("当前金额为" + MoneyThread.money + "，退出取钱系统！");
                    break;
                }
                getMoneyFromConsole();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getMoneyFromConsole() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "请输入你要取的金额：");
        String next = scanner.next();
        try {
            double money = Double.parseDouble(next);
            if (money <= 0) {
                System.out.println(name + "当前的输入为："+next+"，请输入大于0的数字！");
            } else {
                if (MoneyThread.money < money) {
                    System.out.println(name + "当前余额不足，仅剩" + MoneyThread.money);
                } else {
                    MoneyThread.money -= money;
                    System.out.println(name + "取出" + money + "元钱，还剩 " + (MoneyThread.money));
                }
            }

        } catch (NumberFormatException e) {
            System.out.println(name + "当前的输入为："+next+"，请输入正确的数字！");
        }
    }
}