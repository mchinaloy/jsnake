package com.snake.router;

import com.snake.model.domain.request.*;
import com.snake.model.request.EndRequest;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;

import java.util.Collections;

public interface SnakeControllerITFixtureBuilder {

    static Game game(String id) {
        return new Game(id);
    }

    static Turn turn(Integer turn) {
        return new Turn(turn);
    }

    static Board board() {
        return new Board(5, 5, Collections.singletonList(snake()), Collections.singletonList(new Coordinate(1, 2)));
    }

    static Snake snake() {
        return new Snake("aSnake", "snake", 1, Collections.singletonList(new Coordinate(1, 2)));
    }

    static StartRequest startRequest() {
        return new StartRequest(game("aGame"), turn(1), board(), snake());
    }

    static MoveRequest moveRequest() {
        return new MoveRequest(game("aGame"), turn(1), board(), snake());
    }

    static EndRequest endRequest() {
        return new EndRequest(game("aGame"), turn(1), board(), snake());
    }

}
