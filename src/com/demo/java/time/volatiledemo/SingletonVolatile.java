package com.demo.java.time.volatiledemo;

public class SingletonVolatile {

    private volatile static SingletonVolatile instance = null;

    private SingletonVolatile() {

    }

    public static SingletonVolatile getInstance() {
        if (instance == null) {
            synchronized (SingletonVolatile.class) {
                if (instance == null) {
                    instance = new SingletonVolatile();
                }
            }
        }
        return instance;
    }

}
