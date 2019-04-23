package com.snake.model.domain.response;

public enum Color {

    RED("ffffff");

    private final String color;

    Color(final String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

}
