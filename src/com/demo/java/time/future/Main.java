package com.demo.java.time.future;

import java.time.Instant;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            SquareCalculator squareCalculator = new SquareCalculator();
            try {
                Thread.sleep(20000);
                System.out.println("睡觉完成");
                squareCalculator.printQueueSize();
                Future<Integer> future = squareCalculator.calculate(10);
                squareCalculator.printQueueSize();
                while (!future.isDone()) {
                    System.out.println("Calculating..." + Instant.now());
                    Thread.yield();
//                    squareCalculator.printQueueSize();
//                    Thread.sleep(300);
                }

                Integer result = future.get();
                System.out.println(result);
                Thread.sleep(30000);
            } catch (Exception e) {
            } finally {
                squareCalculator.printImAlive();
                System.out.println("计算线程执行完毕");
            }
        }).start();

        Thread.sleep(200000);

    }
}
