package com.snake.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartResponse {

    private String color;
    private String headType;
    private String tailType;

}
