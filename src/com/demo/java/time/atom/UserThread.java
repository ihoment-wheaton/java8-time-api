package com.demo.java.time.atom;

public class UserThread implements Runnable {

    private BouncedResource bouncedResource;

    public UserThread(BouncedResource bouncedResource) {
        this.bouncedResource = bouncedResource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bouncedResource.use();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
