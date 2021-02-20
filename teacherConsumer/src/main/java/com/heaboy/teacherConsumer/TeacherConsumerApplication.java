package com.heaboy.teacherConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.heaboy")

public class TeacherConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherConsumerApplication.class, args);
    }

}
