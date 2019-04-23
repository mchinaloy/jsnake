package com.snake.service.strategy;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static com.snake.service.strategy.StarSnakeStrategyFixtureBuilder.moveRequest;
import static com.snake.service.strategy.StarSnakeStrategyFixtureBuilder.startRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class StarSnakeStrategyUT {

    private StarSnakeStrategy starSnakeStrategy = new StarSnakeStrategy();

    @DisplayName("validRequest_Start_ReturnResponse")
    @Test
    void start() {
        // given
        Mono<StartRequest> startRequest = Mono.just(startRequest());

        // when
        Mono<StartResponse> startResponse = starSnakeStrategy.start(startRequest);

        // then
        StartResponse actualResponse = startResponse.block();

        assertThat(actualResponse, is(notNullValue()));
        assertThat(actualResponse.getColor(), equalTo(starSnakeStrategy.getColor().getColor()));
        assertThat(actualResponse.getHeadType(), equalTo(starSnakeStrategy.getHeadType().getHeadType()));
        assertThat(actualResponse.getTailType(), equalTo(starSnakeStrategy.getTailType().getTailType()));
    }

    @DisplayName("validRequest_Move_ReturnResponse")
    @Test
    void move() {
        // given
        Mono<MoveRequest> moveRequest = Mono.just(moveRequest());

        // when
        Mono<MoveResponse> moveResponse = starSnakeStrategy.move(moveRequest);

        // then
        MoveResponse actualMoveResponse = moveResponse.block();

        assertThat(actualMoveResponse, is(notNullValue()));
        assertThat(actualMoveResponse.getMove(), is(notNullValue()));
    }

}