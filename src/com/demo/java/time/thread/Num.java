package com.demo.java.time.thread;

import com.demo.java.time.User;

import java.util.Optional;

public class Num {

    private int count;

    public void plus() {
        count += 1;
    }

    public int getCount() {
        return count;
    }

    public boolean isEven() {
        if (count % 2 == 0) {
            return true;
        }
        return false;
    }
}
