package com.demo.java.time.thread;

public class EvenThread implements Runnable {

    private Num num;

    public EvenThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            while (num.getCount() <= 100) {
                if (num.isEven()) {
                    System.out.println("打印偶数:" + num.getCount());
                    num.plus();
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException ie) {
                    }
                }
            }
        }
    }
}
