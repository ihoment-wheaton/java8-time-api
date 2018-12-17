package com.demo.java.time.atom;

import java.util.concurrent.Semaphore;

public class BouncedResource {

    private Semaphore semaphore;

    public BouncedResource(int permits) {
        this.semaphore = new Semaphore(permits);
    }

    public void use() throws Exception {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    private void doUse() throws Exception {
        System.out.println(Thread.currentThread().getName() + " 开始douse");
        Thread.sleep((long) (Math.random() * 10000));
        System.out.println(Thread.currentThread().getName() + " 结束douse");
    }
}
