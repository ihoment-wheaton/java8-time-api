package com.demo.java.time.atom;

import java.util.ArrayList;
import java.util.Collections;

public class DemoMain {

    public static void main(String[] args) {
        BouncedResource bouncedResource = new BouncedResource(3);
        Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i ++) {
            new Thread(new UserThread(bouncedResource)).start();
        }
    }
}
