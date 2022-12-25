package com.banmao.advanced_grammar.multithreading.method;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午3:42
 * @description 守护线程的设置
 */
public class ThreadDaemon {

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        // 先设置线程为守护线程，再启动线程
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在辛苦的工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class DaemonThread implements Runnable {

    @Override
    public void run() {
        for (;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一直在聊天，哈哈哈！");
        }
    }
}