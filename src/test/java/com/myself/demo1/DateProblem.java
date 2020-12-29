package com.myself.demo1;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class DateProblem {
    public static void main(String[] args) {
        new DateProblem().execute();
    }

    public void execute() {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(new Worker(latch)).start();
        try {
            latch.await();
            System.out.println("work has been done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Worker implements Runnable {

        private CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("point 1");
            System.out.println("point 2" + new Date());
            latch.countDown();
        }
    }
}