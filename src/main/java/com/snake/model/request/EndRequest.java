package com.snake.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snake.model.domain.request.Board;
import com.snake.model.domain.request.Game;
import com.snake.model.domain.request.Snake;
import com.snake.model.domain.request.Turn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EndRequest {

    private Game game;
    private Turn turn;
    private Board board;

    @JsonProperty("you")
    private Snake snake;
}
