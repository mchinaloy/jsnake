package com.snake.handler;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import com.snake.service.SnakeService;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class SnakeHandler {

    private final SnakeService snakeService;

    public SnakeHandler(final SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    public Mono<ServerResponse> start(final ServerRequest serverRequest) {
        Mono<StartResponse> startResponseMono = snakeService.start(serverRequest.bodyToMono(StartRequest.class));
        return ServerResponse.ok().body(startResponseMono, StartResponse.class);
    }

    public Mono<ServerResponse> move(final ServerRequest serverRequest) {
        Mono<MoveResponse> moveResponseMono = snakeService.move(serverRequest.bodyToMono(MoveRequest.class));
        return ServerResponse.ok().body(moveResponseMono, MoveResponse.class);
    }

    public Mono<ServerResponse> end(final ServerRequest serverRequest) {
        return ServerResponse.ok().build();
    }

    public Mono<ServerResponse> ping(final ServerRequest serverRequest) {
        return ServerResponse.ok().build();
    }

}
