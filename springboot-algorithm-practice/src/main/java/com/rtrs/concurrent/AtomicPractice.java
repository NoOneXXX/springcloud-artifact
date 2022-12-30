package com.rtrs.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicPractice {

    AtomicInteger counts = new AtomicInteger(0);
    volatile int temps = 0;
    public void addNums()
    {
        //temps++;
        int result = counts.addAndGet(1);
        System.out.println("this is data====>" + result);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicPractice ap = new AtomicPractice();

        for (int i = 0; i < 1000 ; i++)
        {
         Thread t = new Thread(ap::addNums);
         t.start();
         t.join();
        }


        System.out.println(ap.counts.get() + "<<<thread name>>>" + Thread.currentThread().getName() + "<<<print this numbers ====>" + ap.temps);

    }
}
