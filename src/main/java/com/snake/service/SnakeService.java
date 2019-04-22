package com.snake.service;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import com.snake.service.strategy.SnakeStrategy;

public class SnakeService {

    private final SnakeStrategy snakeStrategy;

    public SnakeService(SnakeStrategy snakeStrategy) {
        this.snakeStrategy = snakeStrategy;
    }

    public StartResponse start(StartRequest startRequest) {
        return snakeStrategy.start(startRequest);
    }

    public MoveResponse move(MoveRequest moveRequest) {
        return snakeStrategy.move(moveRequest);
    }

}
