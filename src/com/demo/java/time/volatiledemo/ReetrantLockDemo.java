package com.demo.java.time.volatiledemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockDemo {

    public int inc = 0;
    Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        final ReetrantLockDemo test = new ReetrantLockDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> test(test)).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.inc);
    }

    public static void test(ReetrantLockDemo test) {
        for (int j = 0; j < 1000; j++) {
            test.increase();
        }
    }
}
