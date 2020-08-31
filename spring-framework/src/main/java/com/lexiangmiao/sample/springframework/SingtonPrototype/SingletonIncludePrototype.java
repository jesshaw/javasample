package com.lexiangmiao.sample.springframework.SingtonPrototype;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonIncludePrototype {
    @Autowired
    private Prototype prototype;

    public Prototype getPrototype() {
        return prototype;
    }
}
