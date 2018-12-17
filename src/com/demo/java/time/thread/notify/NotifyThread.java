package com.demo.java.time.thread.notify;

import com.demo.java.time.thread.Num;

public class NotifyThread implements Runnable {

    private Num num;

    public NotifyThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {

            }
            num.notify();
            System.out.println("释放一次锁");
        }
    }
}
