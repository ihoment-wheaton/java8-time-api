package com.demo.java.time.thread;

public class TestThread extends Thread {


    @Override
    public void run() {
        yield();
        super.run();
    }
}
