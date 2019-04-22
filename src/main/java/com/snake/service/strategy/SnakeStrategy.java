package com.snake.service.strategy;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;

public interface SnakeStrategy {

    StartResponse start(StartRequest startRequest);

    MoveResponse move(MoveRequest moveRequest);

}
