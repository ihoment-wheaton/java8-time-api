package com.demo.java.time.thread.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {

    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(String.format("%s calls doSave, content = %s", Thread.currentThread().getName(), content));
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
