package com.snake.model.domain.response;

public enum Move {

    UP("up"), DOWN("down"), LEFT("left"), RIGHT("right");

    private final String move;

    Move(final String move) {
        this.move = move;
    }

    public String getMove() {
        return this.move;
    }

}
