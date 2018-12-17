package com.demo.java.time.thread;

public class CardinalThread implements Runnable {

    private Num num;

    public CardinalThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            while (num.getCount() < 100) {
                if (!num.isEven()) {
                    System.out.println("打印奇数:" + num.getCount());
                    num.plus();
                    num.notify();
                }
                try {
                    num.wait();
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}
