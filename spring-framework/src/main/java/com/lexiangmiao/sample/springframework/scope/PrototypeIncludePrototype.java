package com.lexiangmiao.sample.springframework.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class PrototypeIncludePrototype {
    @Autowired
    private Prototype prototype;

    public Prototype getPrototype() {
        return prototype;
    }

}
