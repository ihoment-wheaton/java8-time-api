package com.demo.java.time.thread.balking;

public class BalkingApp {

    public static void main(String[] args) {
        Data data = new Data("/Users/wheaton/Documents/data.txt", "(empty)");
//        Thread changeThread = new Thread(new ChangerThread("ChangerThread", data));
//        changeThread.setName("ChangerThread");
//        changeThread.start();

        Thread saveThread = new Thread(new SaverThread("SaverThread", data));
        saveThread.setName("SaverThread");
        saveThread.start();
    }
}
