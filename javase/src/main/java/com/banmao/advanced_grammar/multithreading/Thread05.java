package com.banmao.advanced_grammar.multithreading;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午2:52
 * @description 启动一个线程T，要求在主线程中去停止线程T
 */
public class Thread05 {

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        stopThread.start();



        // 主线程休眠10s后，停止线程T
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopThread.setLoop(false);
    }
}

class StopThread extends Thread {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println("线程T在运行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "退出");
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}