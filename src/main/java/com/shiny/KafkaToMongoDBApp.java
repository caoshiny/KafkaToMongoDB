package com.shiny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaToMongoDBApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaToMongoDBApp.class, args);
    }
}
