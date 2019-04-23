package com.snake.model.domain.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(builderClassName = "BoardBuilder")
@JsonDeserialize(builder = Board.BoardBuilder.class)
public class Board {

    private final Integer height;
    private final Integer width;
    private final List<Snake> snakes;
    private final List<Coordinate> food;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BoardBuilder {
    }

}
