package com.demo.java.time.thread.guardedtimed;

public class Main {

    public static void main(String[] args) throws Exception {
        Host host = new Host(10000);
        System.out.println("execute BEGIN");
        host.execute();
    }
}
