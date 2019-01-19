package com.demo.java.time.thread.producerconsumer;

import java.util.Random;

public class EaterThread implements Runnable {

    private final Random random;
    private final Table table;

    public EaterThread(Random random, Table table) {
        this.random = random;
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {

        }
    }
}
