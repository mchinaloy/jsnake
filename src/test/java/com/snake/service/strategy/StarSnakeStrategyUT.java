package com.snake.service.strategy;

import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.snake.service.strategy.StarSnakeStrategyFixtureBuilder.*;
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

        // when
        StartResponse startResponse = starSnakeStrategy.start(startRequest());

        // then
        assertThat(startResponse.getColor(), equalTo(starSnakeStrategy.getColor().getColor()));
        assertThat(startResponse.getHeadType(), equalTo(starSnakeStrategy.getHeadType().getHeadType()));
        assertThat(startResponse.getTailType(), equalTo(starSnakeStrategy.getTailType().getTailType()));
    }

    @DisplayName("validRequest_Move_ReturnResponse")
    @Test
    void move() {
        // when
        MoveResponse moveResponse = starSnakeStrategy.move(moveRequest());

        // then
        assertThat(moveResponse.getMove(), is(notNullValue()));
    }


}