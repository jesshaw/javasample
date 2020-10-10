package com.lexiangmiao.sample.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * visualvm先要安装visual gc插件
 * jvisualvm 可以查看GC回收图型变化
 */
public class HeapTest {
    byte[] ba = new byte[100 * 1024];

    public static void main(String[] args) throws InterruptedException {
        List<HeapTest> heapTests = new ArrayList<>();
        while (true) {
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
