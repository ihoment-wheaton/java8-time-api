package com.demo.java.time.thread;

import com.demo.java.time.thread.notify.NotifyThread;
import com.demo.java.time.thread.notify.Receiver;

public class ThreadDemo {

    public static void main(String[] args) throws Exception {
        Num num = new Num();
//        EvenThread evenThread = new EvenThread(num);
//        CardinalThread cardinalThread = new CardinalThread(num);
//        new Thread(evenThread).start();
//        new Thread(cardinalThread).start();

        NotifyThread notifyThread = new NotifyThread(num);
        new Thread(notifyThread).start();

        for (int i = 0; i <= 5; i++) {
            Receiver receiver = new Receiver(num);
            new Thread(receiver).start();
        }
        Thread.sleep(5000);

        for (int i = 0; i <= 4; i++) {
            NotifyThread thread = new NotifyThread(num);
            new Thread(thread).start();
        }

        Thread.State state = Thread.State.BLOCKED;
    }

}


