package com.snake.model.domain.response;

public enum TailType {

    PIXEL("regular");

    private final String tailType;

    TailType (final String tailType) {
        this.tailType = tailType;
    }

    public String getTailType() {
        return this.tailType;
    }
}
