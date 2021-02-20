package com.heaboy.studentConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.heaboy")
public class StudentConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentConsumerApplication.class, args);
    }

}
