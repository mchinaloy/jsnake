package com.snake.config;

import com.snake.handler.SnakeHandler;
import com.snake.service.SnakeService;
import com.snake.service.strategy.SnakeStrategy;
import com.snake.service.strategy.StarSnakeStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SnakeConfig {

    @Bean
    public RouterFunction<ServerResponse> router (SnakeHandler snakeHandler) {
        return route()
            .POST("/start", accept(MediaType.APPLICATION_JSON), snakeHandler::start)
            .POST("/move", accept(MediaType.APPLICATION_JSON), snakeHandler::move)
            .POST("/end", accept(MediaType.APPLICATION_JSON), snakeHandler::end)
            .POST("/ping", accept(MediaType.APPLICATION_JSON), snakeHandler::ping)
            .build();
    }

    @Bean
    public SnakeHandler snakeHandler(SnakeService snakeService) {
        return new SnakeHandler(snakeService);
    }

    @Bean
    public SnakeStrategy snakeStrategy() {
        return new StarSnakeStrategy();
    }

    @Bean
    public SnakeService snakeService(SnakeStrategy snakeStrategy) {
        return new SnakeService(snakeStrategy);
    }

}
