package com.snake.model.domain.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "TurnBuilder")
@JsonDeserialize(builder = Turn.TurnBuilder.class)
public class Turn {

    private final Integer turn;

    @JsonPOJOBuilder(withPrefix = "")
    public static class TurnBuilder {
    }

}
