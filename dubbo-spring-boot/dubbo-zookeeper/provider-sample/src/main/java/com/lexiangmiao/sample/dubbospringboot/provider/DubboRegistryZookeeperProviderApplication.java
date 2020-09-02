package com.lexiangmiao.sample.dubbospringboot.provider;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DubboRegistryZookeeperProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboRegistryZookeeperProviderApplication.class).run(args);
    }

}
