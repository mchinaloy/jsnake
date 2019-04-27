package com.snake.service.strategy;

import com.snake.model.domain.request.Board;
import com.snake.model.domain.request.Coordinate;
import com.snake.model.domain.request.Game;
import com.snake.model.domain.request.Snake;
import com.snake.model.domain.request.Turn;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;

import java.util.Collections;

public interface StarSnakeStrategyFixtureBuilder {

    static Game game(String id) {
        return Game.builder()
                .id(id)
                .build();
    }

    static Turn turn(Integer turn) {
        return new Turn(turn);
    }

    static Board board() {
        return Board.builder()
                .height(5)
                .width(5)
                .snakes(Collections.singletonList(snake()))
                .food(Collections.singletonList(Coordinate.builder()
                        .x(2)
                        .y(2)
                        .build()))
                .build();
    }

    static Snake snake() {
        return Snake.builder()
                .id("aSnake")
                .name("snake")
                .health(1)
                .body(Collections.singletonList(Coordinate.builder()
                        .x(1)
                        .y(2)
                        .build()))
                .build();
    }

    static StartRequest startRequest() {
        return StartRequest.builder()
                .board(board())
                .turn(turn(1))
                .game(game("aGameId"))
                .you(snake())
                .build();
    }

    static MoveRequest moveRequest() {
        return MoveRequest.builder()
                .board(board())
                .game(game("aGameId"))
                .you(snake())
                .turn(turn(1))
                .build();
    }

}
