package com.snake.model.domain.strategy.star;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Edge {

    private final double length;
    private final Node start;
    private final Node end;

}
