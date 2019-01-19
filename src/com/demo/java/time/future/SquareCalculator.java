package com.demo.java.time.future;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SquareCalculator {

//    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private ExecutorService executor;


    public SquareCalculator() {
        executor = new ThreadPoolExecutor(5, 5,10L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30) {

            @Override
            public boolean offer(Runnable task) {
                return super.offer(task);
            }
        },new ThreadFactory() {

            private final AtomicInteger threadNumber = new AtomicInteger(1);

            public Thread newThread(Runnable task) {
                Thread thread = new Thread(task, "MarketplaceWebServiceClient-Thread-" +
                        threadNumber.getAndIncrement());
                thread.setDaemon(true);
                if (thread.getPriority() != Thread.NORM_PRIORITY) {
                    thread.setPriority(Thread.NORM_PRIORITY);
                }
                return thread;
            }
        }, new RejectedExecutionHandler() {

                    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
                        if (!executor.isShutdown()) {
                            task.run();
                        }
                    }
                });
//        ((ThreadPoolExecutor) executor).allowCoreThreadTimeOut(true);
    }

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(20000);
            return input * input;
        });
    }

    public void shutDown() {
        executor.shutdown();
    }

    public void printQueueSize() {
        System.out.println("Queue Size: " + ((ThreadPoolExecutor)executor).getQueue().size());
    }

    public void printImAlive() {
        System.out.println("Im alive");
    }
}
