package com.snake.model.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Integer height;
    private Integer width;
    private List<Snake> snakes;
    private List<Coordinate> food;

}
