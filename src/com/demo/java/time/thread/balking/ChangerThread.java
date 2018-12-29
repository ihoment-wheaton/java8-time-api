package com.demo.java.time.thread.balking;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChangerThread implements Runnable {

    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change(String.format("No.%s", i));
                TimeUnit.MILLISECONDS.sleep(1000);
                data.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
