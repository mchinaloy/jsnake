package com.snake.model.domain.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder(builderClassName = "CoordinateBuilder")
@JsonDeserialize(builder = Coordinate.CoordinateBuilder.class)
public class Coordinate {

    private final Integer x;
    private final Integer y;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CoordinateBuilder {
    }

}
