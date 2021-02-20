package com.heaboy.testConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.heaboy")
public class TestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestConsumerApplication.class, args);
    }

}
