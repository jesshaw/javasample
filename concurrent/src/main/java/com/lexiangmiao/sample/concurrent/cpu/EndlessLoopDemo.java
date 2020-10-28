package com.lexiangmiao.sample.concurrent.cpu;

import java.util.Random;

public class EndlessLoopDemo {
    public static void main(String[] args) {
        while (true) {
            System.out.println(new Random().nextInt(1000000));
        }
    }
}
