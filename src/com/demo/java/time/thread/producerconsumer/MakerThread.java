package com.demo.java.time.thread.producerconsumer;

import java.util.Random;

public class MakerThread implements Runnable {

    private final String name;
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        this.name = name;
        this.random = new Random(seed);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
            }
        } catch (InterruptedException e) {

        }
    }

    private static synchronized int nextId() {
        return id++;
    }

    public String getName() {
        return name;
    }
}
