package com.banmao.advanced_grammar.multithreading;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午4:35
 * @description 线程状态
 *
 */
public class ThreadStatus {

    public static void main(String[] args) {
        ThreadStatusTest threadStatusTest = new ThreadStatusTest();
        Thread thread = new Thread(threadStatusTest);
        System.out.println(thread.getName() + "state：" + thread.getState());
        thread.start();

        while (Thread.State.TERMINATED != thread.getState()) {
            System.out.println(thread.getName() + "state：" + thread.getState());
            try {
                // 让主线程500ms输出一次
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(thread.getName() + "state：" + thread.getState());
    }
}

class ThreadStatusTest implements Runnable {

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}