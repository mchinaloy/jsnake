package com.snake.service.strategy;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import reactor.core.publisher.Mono;

public interface SnakeStrategy {

    Mono<StartResponse> start(final Mono<StartRequest> startRequest);

    Mono<MoveResponse> move(final Mono<MoveRequest> moveRequest);

}
