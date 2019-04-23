package com.snake.service;

import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import com.snake.service.strategy.SnakeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.snake.service.SnakeServiceFixtureBuilder.moveRequest;
import static com.snake.service.SnakeServiceFixtureBuilder.moveResponse;
import static com.snake.service.SnakeServiceFixtureBuilder.startRequest;
import static com.snake.service.SnakeServiceFixtureBuilder.startResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SnakeServiceUT {

    private SnakeStrategy snakeStrategy = mock(SnakeStrategy.class);
    private SnakeService snakeService = new SnakeService(snakeStrategy);

    @DisplayName("validRequest_Start_DelegateToStrategy")
    @Test
    void start() {
        // given
        StartRequest startRequest = startRequest();

        // when
//        when(snakeStrategy.start(eq(startRequest))).thenReturn(startResponse());
//        StartResponse startResponse = snakeService.start(startRequest);

        // then
//        verify(snakeStrategy).start(eq(startRequest));
//        assertThat(startResponse, is(notNullValue()));
    }

    @DisplayName("validRequest_Move_DelegateToStrategy")
    @Test
    void move() {
        // given
        MoveRequest moveRequest = moveRequest();

        // when
//        when(snakeStrategy.move(eq(moveRequest))).thenReturn(moveResponse());
//        MoveResponse moveResponse = snakeService.move(moveRequest());

        // then
//        verify(snakeStrategy).move(eq(moveRequest));
//        assertThat(moveResponse, is(notNullValue()));
    }

}