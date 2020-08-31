package com.lexiangmiao.sample.springframework.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonIncludeSingleton {
    @Autowired
    private Singleton singleton;

    public Singleton getSingleton() {
        return singleton;
    }
}
