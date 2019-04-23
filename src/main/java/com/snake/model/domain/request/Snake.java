package com.snake.model.domain.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(builderClassName = "SnakeBuilder")
@JsonDeserialize(builder = Snake.SnakeBuilder.class)
public class Snake {

    private final String id;
    private final String name;
    private final Integer health;
    private final List<Coordinate> body;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SnakeBuilder {
    }

}
