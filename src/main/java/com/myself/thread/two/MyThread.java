package com.myself.thread.two;

import lombok.SneakyThrows;

public class MyThread extends Thread {
    String name = "";

    @SneakyThrows
    @Override

    public void run() {

        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        if ("".equals(name) || name == null) {
            Thread.currentThread().stop();
        }
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + "线程执行结束");
    }

    public MyThread(String name) {
        super.setName(name);
        this.name = name;

    }

    public MyThread() {
    }

}