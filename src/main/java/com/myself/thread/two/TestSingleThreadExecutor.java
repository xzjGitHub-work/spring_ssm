package com.myself.thread.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadExecutor {

    /**
     * @describe:单线线程池
     * @author:xzj
     * @createDate:2021/1/12 10:41
     * @param:[args]
     * @return:void
     */
    public static void main(String[] args) {

        //创建一个可重用固定线程数的线程池

        ExecutorService pool = Executors.newSingleThreadExecutor();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口

        Thread t1 = new MyThread();
        Thread t2 = new MyThread("线程2");
        pool.execute(t1);
        Thread t3 = new MyThread("线程3");

        Thread t4 = new MyThread("线程4");

        Thread t5 = new MyThread("线程5");

        //将线程放入池中进行执行
        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //关闭线程池

        pool.shutdown();

    }

}