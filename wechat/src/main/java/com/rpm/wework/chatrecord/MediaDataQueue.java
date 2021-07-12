package com.rpm.wework.chatrecord;


import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public enum MediaDataQueue {
    INSTANCE;
    private final BlockingDeque<Map<String, String>> deque = new LinkedBlockingDeque<Map<String, String>>();

    public BlockingDeque<Map<String, String>> get() {
        return deque;
    }

    public void add(Map<String, String> map) {
        deque.add(map);
    }
}
