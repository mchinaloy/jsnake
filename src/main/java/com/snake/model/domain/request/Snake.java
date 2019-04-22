package com.snake.model.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snake {

    private String id;
    private String name;
    private Integer health;
    private List<Coordinate> body;

}
