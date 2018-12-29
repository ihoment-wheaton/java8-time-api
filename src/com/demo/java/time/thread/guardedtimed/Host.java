package com.demo.java.time.thread.guardedtimed;

import java.time.Instant;
import java.util.concurrent.TimeoutException;

/**
 * 带有超时的Host类
 */
public class Host {

    private final long timeout;
    // 方法正常执行时为true
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }

    public synchronized void execute() throws InterruptedException,TimeoutException {
        long start = System.currentTimeMillis();
        while (!ready) {
            long now = System.currentTimeMillis();
            long reset = timeout - (now - start);
            if (reset <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(reset);
        }
        doExecute();
    }

    public void doExecute() {
        System.out.println(String.format("%s calls doExecute", Thread.currentThread().getName()));
    }
}
