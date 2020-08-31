package com.lexiangmiao.sample.springframework.scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ScopeConfig.class)
public class SingletonIncludePrototypeTest {
    @Autowired
    private ApplicationContext app;

    /**
     * 原型Bean包含单例bean,父对像变化，子对象因为是单例不变
     */
    @Test
    public void prototypeIncludeSingleton() {
        Singleton singleton = app.getBean(Singleton.class);
        PrototypeIncludeSingleton prototypeIncludeSingleton = app.getBean(PrototypeIncludeSingleton.class);
        PrototypeIncludeSingleton prototypeIncludeSingleton2 = app.getBean(PrototypeIncludeSingleton.class);

        System.out.println("---prototype include singleton--");
        System.out.println(singleton);
        System.out.println(prototypeIncludeSingleton);
        System.out.println(prototypeIncludeSingleton.getSingleton());
        System.out.println(prototypeIncludeSingleton2);
        System.out.println(prototypeIncludeSingleton2.getSingleton());
    }

    /**
     * 单例bean包含原型bean,父对像不变，子对象也不变
     */
    @Test
    public void singletonIncludePrototype() {
        Prototype prototype = app.getBean(Prototype.class);
        SingletonIncludePrototype singletonIncludePrototype = app.getBean(SingletonIncludePrototype.class);
        SingletonIncludePrototype singletonIncludePrototype2 = app.getBean(SingletonIncludePrototype.class);
        System.out.println("---singleton include prototype--");
        System.out.println(prototype);
        System.out.println(singletonIncludePrototype);
        System.out.println(singletonIncludePrototype.getPrototype());
        System.out.println(singletonIncludePrototype2);
        System.out.println(singletonIncludePrototype2.getPrototype());
    }

    /**
     * 原型bean包含原型bean,父对像变化，子对象也变化
     */
    @Test
    public void prototypeIncludePrototype() {
        PrototypeIncludePrototype prototypeIncludePrototype = app.getBean(PrototypeIncludePrototype.class);
        PrototypeIncludePrototype prototypeIncludePrototype2 = app.getBean(PrototypeIncludePrototype.class);
        System.out.println("---prototype include prototype--");
        System.out.println(prototypeIncludePrototype);
        System.out.println(prototypeIncludePrototype.getPrototype());
        System.out.println(prototypeIncludePrototype2);
        System.out.println(prototypeIncludePrototype2.getPrototype());
    }

    /**
     * 单例bean包含单例bean,父对像不变化，子对象也不变化
     */
    @Test
    public void singletonIncludeSingleton() {
        SingletonIncludeSingleton singletonIncludeSingleton = app.getBean(SingletonIncludeSingleton.class);
        SingletonIncludeSingleton singletonIncludeSingleton2 = app.getBean(SingletonIncludeSingleton.class);
        System.out.println("---singleton include singleton--");
        System.out.println(singletonIncludeSingleton);
        System.out.println(singletonIncludeSingleton.getSingleton());
        System.out.println(singletonIncludeSingleton2);
        System.out.println(singletonIncludeSingleton2.getSingleton());
    }
}
