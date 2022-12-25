package com.banmao.advanced_grammar.multithreading.homework_;

import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午8:54
 * @description
 */
public class HomeWork01 {

    public static void main(String[] args) {
        // 第一个线程循环随机打印1-100之内的整数
        // 直到第二个线程从键盘读取了Q命令
        Work01Thread work01Thread = new Work01Thread();
        new Thread(work01Thread).start();
        Work02Thread work02Thread = new Work02Thread(work01Thread);
        new Thread(work02Thread).start();
    }
}

class Work01Thread implements Runnable {

    boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((int)(Math.random() * 100 + 1));
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Work02Thread implements Runnable {

    private Work01Thread work01Thread;
    private Scanner scanner = new Scanner(System.in);

    public Work02Thread(Work01Thread work01Thread) {
        this.work01Thread = work01Thread;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你的指令（Q表示退出）");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q') {
                work01Thread.setLoop(false);
                break;
            }
        }

    }

}