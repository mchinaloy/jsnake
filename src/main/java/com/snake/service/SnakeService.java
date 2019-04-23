package com.snake.service;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import com.snake.service.strategy.SnakeStrategy;
import reactor.core.publisher.Mono;

public class SnakeService {

    private final SnakeStrategy snakeStrategy;

    public SnakeService(SnakeStrategy snakeStrategy) {
        this.snakeStrategy = snakeStrategy;
    }

    public Mono<StartResponse> start(Mono<StartRequest> startRequest) {
        return snakeStrategy.start(startRequest);
    }

    public Mono<MoveResponse> move(Mono<MoveRequest> moveRequest) {
        return snakeStrategy.move(moveRequest);
    }

}
