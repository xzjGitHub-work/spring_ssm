package com.myself.thread.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {

    public static void main(String[] args) {

        //创建一个可重用固定线程数的线程池

        ExecutorService pool = Executors.newFixedThreadPool(5);

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口

        Thread t1 = new MyThread("1");

        Thread t2 = new MyThread("2");

        Thread t3 = new MyThread("3");

        Thread t4 = new MyThread("4");

        Thread t5 = new MyThread("5");

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