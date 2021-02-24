package com.lexiangmiao.sample.db.liquibase;

import liquibase.Liquibase;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class LiquibaseApp {
    public static void main(String[] args) {
        SpringApplication.run(LiquibaseApp.class, args);
    }

    //    @Bean
//    public SpringLiquibase liquibase(DataSource dataSource) {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog("classpath:/config/liquibase/master.xml");
//        liquibase.setShouldRun(true);
////        liquibase.setTag("1.0");
////        liquibase.setContexts(liquiBasePropertyResolver.getProperty("context"));
////        liquibase.setShouldRun(property.getDatasource().isRunLiquibase());
////        releaseLiquibaseLocks(dataSource);
////        clearLiquibaseCheckSums(dataSource);
////        log.debug("Configuring Liquibase and versioning the database ... Please wait!");
//        return liquibase;
//    }
}
