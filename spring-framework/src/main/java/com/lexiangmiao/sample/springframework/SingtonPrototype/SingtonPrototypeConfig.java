package com.lexiangmiao.sample.springframework.SingtonPrototype;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingtonPrototypeConfig {


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Singleton singleton() {
        return new Singleton();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonIncludePrototype singletonIncludePrototype() {
        return new SingletonIncludePrototype();
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Prototype prototype() {
        return new Prototype();
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeIncludeSingleton prototypeIncludeSingleton() {
        return new PrototypeIncludeSingleton();
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeIncludePrototype prototypeIncludePrototype() {
        return new PrototypeIncludePrototype();
    }
}
