package com.snake.model.domain.response;

public enum HeadType {

    SHARP("beluga");

    private final String headType;

    HeadType(final String headType) {
        this.headType = headType;
    }

    public String getHeadType() {
        return this.headType;
    }

}
