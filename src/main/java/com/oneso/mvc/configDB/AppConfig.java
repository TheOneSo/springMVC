package com.oneso.mvc.configDB;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private static final String CHANGELOG_PACKAGE = "com.oneso.mvc.configDB.changelogs";

    @Bean
    public Mongock mongock(MongoProps props, MongoClient client) {
        return new SpringMongockBuilder(client, props.getDatabase(), CHANGELOG_PACKAGE)
                .setLockQuickConfig()
                .build();
    }
}
