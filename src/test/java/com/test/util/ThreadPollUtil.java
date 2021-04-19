package com.test.util;

import org.junit.Test;

import java.text.ParseException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/4/16 11:20
 */
public class ThreadPollUtil {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            pool.execute(() -> {
                try {
                    Thread.sleep(1000l);
                    System.out.println("11111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + finalI + "执行了");
            });
            countDownLatch.countDown();
        }
//        pool.shutdown();
        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("主线程执行了");
    }

    @Test
    public void test01() {


        try {
            if (false){
                throw new ParseException("222222", 4);
            }

        } catch (ParseException e) {
            if (e instanceof ParseException) {
                System.out.println("捕捉到了ParseException ");
            }
            System.out.println("捕捉到了Exception ");

        }finally {
            System.out.println("执行了");
        }

    }
}
