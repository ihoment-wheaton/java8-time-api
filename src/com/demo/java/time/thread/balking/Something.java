package com.demo.java.time.thread.balking;

import java.util.ArrayList;
import java.util.List;

public class Something {

    private boolean initialized = false;

    public synchronized void init() {
        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
        List<String> test = new ArrayList<>();
    }

    private void doInit() {

    }
}
