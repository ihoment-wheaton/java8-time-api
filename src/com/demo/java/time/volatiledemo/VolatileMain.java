package com.demo.java.time.volatiledemo;

public class VolatileMain {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws Exception {
        for (int m = 0; m < 100; m++) {
            final VolatileMain test = new VolatileMain();
            for (int i = 0; i < 10; i++) {
                new Thread(() -> test(test)).start();
            }

            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
            System.out.println(test.inc);
        }
    }

    public static void test(VolatileMain test) {
        for (int j = 0; j < 1000; j++) {
            test.increase();
        }
    }
}
