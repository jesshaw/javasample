package com.lexiangmiao.sample.springframework;

import com.lexiangmiao.sample.springframework.SingtonPrototype.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringFrameworkApplication {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
        app.register(SingtonPrototypeConfig.class);
        app.refresh();

        Singleton singleton = app.getBean(Singleton.class);
        PrototypeIncludeSingleton prototypeIncludeSingleton = app.getBean(PrototypeIncludeSingleton.class);
        System.out.println("---prototype include singleton--");
        System.out.println(singleton);
        System.out.println(prototypeIncludeSingleton);
        System.out.println(prototypeIncludeSingleton.getSingleton());
        PrototypeIncludeSingleton prototypeIncludeSingleton2 = app.getBean(PrototypeIncludeSingleton.class);
        System.out.println(prototypeIncludeSingleton2);
        System.out.println(prototypeIncludeSingleton2.getSingleton());


        System.out.println("---singleton include prototype--");
        Prototype prototype = app.getBean(Prototype.class);
        System.out.println(prototype);
        SingletonIncludePrototype singletonIncludePrototype = app.getBean(SingletonIncludePrototype.class);
        System.out.println(singletonIncludePrototype);
        System.out.println(singletonIncludePrototype.getPrototype());
        Thread.sleep(100);
        SingletonIncludePrototype singletonIncludePrototype2 = app.getBean(SingletonIncludePrototype.class);
        System.out.println(singletonIncludePrototype2);
        System.out.println(singletonIncludePrototype2.getPrototype());


        System.out.println("---prototype include prototype--");
        PrototypeIncludePrototype prototypeIncludePrototype = app.getBean(PrototypeIncludePrototype.class);
        System.out.println(prototypeIncludePrototype);
        System.out.println(prototypeIncludePrototype.getPrototype());
        PrototypeIncludePrototype prototypeIncludePrototype2 = app.getBean(PrototypeIncludePrototype.class);
        System.out.println(prototypeIncludePrototype2);
        System.out.println(prototypeIncludePrototype2.getPrototype());
    }
}
