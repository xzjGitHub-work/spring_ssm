package com.myself.thread.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {

    public static void main(String[] args) {

        //创建一个可重用固定线程数的线程池

        ExecutorService pool = Executors.newCachedThreadPool();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口

        Thread t1 = new MyThread("one");

        Thread t2 = new MyThread("two");

        Thread t3 = new MyThread("three");

        Thread t4 = new MyThread("four");

        Thread t5 = new MyThread("five");

        //将线程放入池中进行执行

        pool.execute(t1);

        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //关闭线程池

        pool.shutdown();

    }

}