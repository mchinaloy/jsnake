package com.snake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.snake")
public class JSnakeApp {

    public static void main(String[] args) {
        SpringApplication.run(JSnakeApp.class, args);
    }

}
