package com.snake.model.domain;

import lombok.Value;

import java.util.List;

@Value
public class Board {

    private final Integer height;
    private final Integer weight;
    private final List<Snake> snakes;
    private final List<Coordinate> food;

}
