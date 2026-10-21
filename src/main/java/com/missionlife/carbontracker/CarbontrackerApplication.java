package com.missionlife.carbontracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.missionlife.carbontracker.repository")
@EnableMongoRepositories(basePackages = "com.missionlife.carbontracker.repository")
public class CarbontrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbontrackerApplication.class, args);
    }
}