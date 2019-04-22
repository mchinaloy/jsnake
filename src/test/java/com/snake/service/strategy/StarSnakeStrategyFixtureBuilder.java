package com.snake.service.strategy;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;

public interface StarSnakeStrategyFixtureBuilder {

    static StartRequest startRequest() {
        return new StartRequest();
    }

    static MoveRequest moveRequest() {
        return new MoveRequest();
    }

}
