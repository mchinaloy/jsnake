package com.snake.model.domain;

import lombok.Value;

import java.util.List;

@Value
public class Snake {

    private final String id;
    private final String name;
    private final Integer health;
    private final List<Coordinate> body;

}
