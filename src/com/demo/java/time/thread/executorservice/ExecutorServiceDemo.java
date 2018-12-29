package com.demo.java.time.thread.executorservice;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceDemo {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread();
        thread.setDaemon(true);
        thread.start();
            ExecutorService asyncExecutor = new ThreadPoolExecutor(5,
                    5, 60L, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(5) {

                        @Override
                        public boolean offer(Runnable task) {
                            System.out.println("Maximum number of concurrent threads reached, queuing task...");
                            return super.offer(task);
                        }
                    },
                    new ThreadFactory() {

                        private final AtomicInteger threadNumber = new AtomicInteger(1);

                        public Thread newThread(Runnable task) {
                            Thread thread = new Thread(task, "MarketplaceWebServiceClient-Thread-" +
                                    threadNumber.getAndIncrement());
                            thread.setDaemon(true);
                            if (thread.getPriority() != Thread.NORM_PRIORITY) {
                                thread.setPriority(Thread.NORM_PRIORITY);
                            }
                            System.out.println("ThreadFactory created new thread: " + thread.getName());
                            return thread;
                        }
                    },
                    new RejectedExecutionHandler() {

                        public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
                            System.out.println("Maximum number of concurrent threads reached, and queue is full. " +
                                    "Running task in the calling thread..." + Thread.currentThread().getName());
                            if (!executor.isShutdown()) {
                                task.run();
                            }
                        }
                    });
        System.out.println("执行完毕");
        Thread.sleep(100000);
    }
}
