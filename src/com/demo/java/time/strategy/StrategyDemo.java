package com.demo.java.time.strategy;

public class StrategyDemo {

    public static void main(String[] args) {
        HardPolice hardPolice = new HardPolice();
        NicePolice nicePolice = new NicePolice();

        Situation situation = new Situation(hardPolice);
        situation.handleByPolice(10);

        situation = new Situation(nicePolice);
        situation.handleByPolice(100);
    }
}
