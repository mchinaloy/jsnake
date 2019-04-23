package com.snake.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.snake.model.domain.request.Board;
import com.snake.model.domain.request.Game;
import com.snake.model.domain.request.Snake;
import com.snake.model.domain.request.Turn;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "EndRequestBuilder")
@JsonDeserialize(builder = EndRequest.EndRequestBuilder.class)
public class EndRequest {

    private final Game game;
    private final Turn turn;
    private final Board board;

    @JsonProperty("you")
    private final Snake snake;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EndRequestBuilder {
    }

}
