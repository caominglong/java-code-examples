package com.banmao.advanced_grammar.multithreading.method;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/27 下午3:26
 * @description 线程的join方法使用
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "执行：" + (i + 1));
            if (i + 1 == 5) {
                System.out.println("让子线程插队执行，等子线程执行完了之后，再执行主线程");
                // thread.join();
                Thread.yield(); // 礼让，不一定成功
            }
        }
    }
}

class JoinThread implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "执行：" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count >= 20) {
                break;
            }
        }
    }
}