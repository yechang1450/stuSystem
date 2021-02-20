package com.heaboy.questionnaireConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.heaboy")
public class questionnaireConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(questionnaireConsumerApplication.class, args);
    }
}
