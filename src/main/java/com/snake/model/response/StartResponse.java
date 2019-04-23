package com.snake.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "StartResponseBuilder")
@JsonDeserialize(builder = StartResponse.StartResponseBuilder.class)
public class StartResponse {

    private final String color;
    private final String headType;
    private final String tailType;

    @JsonPOJOBuilder(withPrefix = "")
    public static class StartResponseBuilder {
    }

}
