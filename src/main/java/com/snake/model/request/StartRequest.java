package com.snake.model.request;

import com.snake.model.domain.Board;
import com.snake.model.domain.Game;
import com.snake.model.domain.Snake;
import com.snake.model.domain.Turn;
import lombok.Value;

@Value
public class StartRequest {

    private final Game game;
    private final Turn turn;
    private final Board board;
    private final Snake snake;

}
