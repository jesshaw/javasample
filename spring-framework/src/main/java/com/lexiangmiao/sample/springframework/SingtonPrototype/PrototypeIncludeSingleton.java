package com.lexiangmiao.sample.springframework.SingtonPrototype;

import org.springframework.beans.factory.annotation.Autowired;

public class PrototypeIncludeSingleton {
    @Autowired
    private Singleton singleton;

    public Singleton getSingleton() {
        return singleton;
    }
}
