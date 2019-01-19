package com.demo.java.time.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) throws Exception {
        final AtomicIntegerDemo test = new AtomicIntegerDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> test(test)).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.inc);
    }

    public static void test(AtomicIntegerDemo test) {
        for (int j = 0; j < 1000; j++) {
            test.increase();
        }
    }
}
