package com.demo.java.time.thread.balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SaverThread implements Runnable {

    private final Data data;

    public SaverThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save();
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
