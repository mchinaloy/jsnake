package com.snake.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "MoveResponseBuilder")
@JsonDeserialize(builder = MoveResponse.MoveResponseBuilder.class)
public class MoveResponse {

    private final String move;

    @JsonPOJOBuilder(withPrefix = "")
    public static class MoveResponseBuilder {
    }

}
