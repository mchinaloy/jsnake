package com.snake.controller;

import com.snake.model.domain.Board;
import com.snake.model.domain.Game;
import com.snake.model.domain.Snake;
import com.snake.model.domain.Turn;
import com.snake.model.request.StartRequest;

import java.util.Collections;

public class SnakeControllerUTestFixtureBuilder {

    public Game game(String id) {
        return new Game(id);
    }

    public Turn turn(Integer turn) {
        return new Turn(turn);
    }

    public Board board() {
        return new Board(5, 5, Collections.emptyList(), Collections.emptyList());
    }

    public Snake snake() {
        return new Snake("aSnake", "snake", 1, Collections.emptyList());
    }

    public StartRequest startRequest() {
        return new StartRequest(game("aGame"), turn(1), board(), snake());
    }

}
