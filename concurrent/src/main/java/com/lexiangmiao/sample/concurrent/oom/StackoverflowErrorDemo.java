package com.lexiangmiao.sample.concurrent.oom;

public class StackoverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
