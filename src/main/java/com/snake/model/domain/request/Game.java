package com.snake.model.domain.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "GameBuilder")
@JsonDeserialize(builder = Game.GameBuilder.class)
public class Game {

    private final String id;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GameBuilder {
    }

}
