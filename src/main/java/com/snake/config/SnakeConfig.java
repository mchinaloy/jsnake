package com.snake.config;

import com.snake.service.SnakeService;
import com.snake.service.strategy.SnakeStrategy;
import com.snake.service.strategy.StarSnakeStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnakeConfig {

    @Bean
    public SnakeStrategy snakeStrategy() {
        return new StarSnakeStrategy();
    }

    @Bean
    public SnakeService snakeService(SnakeStrategy snakeStrategy) {
        return new SnakeService(snakeStrategy);
    }

}
