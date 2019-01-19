package com.demo.java.time.volatiledemo;

public class VolatileFlagDemo {

    volatile boolean flag = false;

    public void loop() {
        while (!flag) {
            doSomething();
        }
    }

    public void doSomething() {

    }

    public void setFlag() {
        flag = true;
    }
}
