package com.snake.service;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;

public interface SnakeServiceFixtureBuilder {

    static StartRequest startRequest() {
        return new StartRequest();
    }

    static StartResponse startResponse() {
        return new StartResponse();
    }

    static MoveRequest moveRequest() {
        return new MoveRequest();
    }

    static MoveResponse moveResponse() {
        return new MoveResponse();
    }

}
