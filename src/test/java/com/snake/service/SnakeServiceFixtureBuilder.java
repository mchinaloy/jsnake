package com.snake.service;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;

public interface SnakeServiceFixtureBuilder {

    static StartRequest startRequest() {
        return StartRequest.builder().build();
    }

    static StartResponse startResponse() {
        return StartResponse.builder().build();
    }

    static MoveRequest moveRequest() {
        return MoveRequest.builder().build();
    }

    static MoveResponse moveResponse() {
        return MoveResponse.builder().build();
    }

}
