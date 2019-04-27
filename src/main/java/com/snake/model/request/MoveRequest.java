package com.snake.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.snake.model.domain.request.Board;
import com.snake.model.domain.request.Game;
import com.snake.model.domain.request.Snake;
import com.snake.model.domain.request.Turn;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "MoveRequestBuilder")
@JsonDeserialize(builder = MoveRequest.MoveRequestBuilder.class)
public class MoveRequest {

    private final Game game;
    private final Turn turn;
    private final Board board;
    private final Snake you;

    @JsonPOJOBuilder(withPrefix = "")
    public static class MoveRequestBuilder {
    }

}
