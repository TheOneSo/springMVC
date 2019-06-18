package com.oneso.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableMongoRepositories("com.oneso.mvc.repository")
public class MvcApplication {

    public static void main(String[] args) { SpringApplication.run(MvcApplication.class, args); }

}
