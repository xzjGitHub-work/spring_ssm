package com.myself.util;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class TestCountDownlatch {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    @Test
    public void test01() throws InterruptedException {
        new Thread(() -> {
            System.out.println("线程一开始了");
            try {
                Thread.sleep(3000);
//                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "执行完毕1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("线程二开始了");
            try {
                Thread.sleep(5000);
//                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "执行完毕2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "执行完毕00");
    }


}