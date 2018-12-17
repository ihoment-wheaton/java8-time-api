package com.demo.java.time.thread.notify;

import com.demo.java.time.thread.Num;

public class Receiver implements Runnable {

    private Num num;

    public Receiver(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(String.format("线程等待中 %s", Thread.currentThread().getName()));
//        try {
//            num.wait();
//        } catch (InterruptedException ie) {
//        }
        synchronized (num) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {

            }
            System.out.println(String.format("等待结束 %s", Thread.currentThread().getName()));
        }
    }
}
