package com.snake.service.strategy;

import com.snake.model.domain.response.Color;
import com.snake.model.domain.response.HeadType;
import com.snake.model.domain.response.Move;
import com.snake.model.domain.response.TailType;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import lombok.Getter;

import java.util.Random;

@Getter
public class StarSnakeStrategy implements SnakeStrategy {

    private final Color color = Color.RED;
    private final HeadType headType = HeadType.SHARP;
    private final TailType tailType = TailType.PIXEL;

    @Override
    public StartResponse start(StartRequest startRequest) {
        return new StartResponse(Color.RED.getColor(), HeadType.SHARP.getHeadType(), TailType.PIXEL.getTailType());
    }

    @Override
    public MoveResponse move(MoveRequest moveRequest) {
        Random random = new Random();
        int selection = random.nextInt(4) + 1;
        if (selection == 1) {
            return new MoveResponse(Move.UP.getMove());
        } else if (selection == 2) {
            return new MoveResponse(Move.DOWN.getMove());
        } else if (selection == 3) {
            return new MoveResponse(Move.LEFT.getMove());
        }
        return new MoveResponse(Move.RIGHT.getMove());
    }

}
