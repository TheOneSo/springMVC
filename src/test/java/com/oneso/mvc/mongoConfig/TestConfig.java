package com.oneso.mvc.mongoConfig;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    private static final String CHANGELOG_PACKAGE = "com.oneso.mvc.mongoConfig.changelog";

    @Bean
    public Mongock mongock(MongoClient client) {
        return new SpringMongockBuilder(client, "test", CHANGELOG_PACKAGE)
                .setLockQuickConfig()
                .build();
    }
}
