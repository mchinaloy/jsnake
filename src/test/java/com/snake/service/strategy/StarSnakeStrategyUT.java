package com.snake.service.strategy;

import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static com.snake.service.strategy.StarSnakeStrategyFixtureBuilder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class StarSnakeStrategyUT {

    private StarSnakeStrategy starSnakeStrategy = new StarSnakeStrategy();

    private WebTestClient webTestClient;

    @DisplayName("validRequest_Start_ReturnResponse")
    @Test
    void start() {
        // given
        Mono<StartRequest> startRequest = Mono.just(startRequest());

        // when
        Mono<StartResponse> startResponse = starSnakeStrategy.start(startRequest);

        // then
        startResponse.map(response -> {
            assertThat(response.getColor(), equalTo(starSnakeStrategy.getColor().getColor()));
            assertThat(response.getHeadType(), equalTo(starSnakeStrategy.getHeadType().getHeadType()));
            assertThat(response.getTailType(), equalTo(starSnakeStrategy.getTailType().getTailType()));
            return response;
        });
    }

    @DisplayName("validRequest_Move_ReturnResponse")
    @Test
    void move() {
        // when
//        MoveResponse moveResponse = starSnakeStrategy.move(moveRequest());

        // then
//        assertThat(moveResponse.getMove(), is(notNullValue()));
    }


}