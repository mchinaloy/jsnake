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
import reactor.core.publisher.Mono;

import java.util.Random;

@Getter
public class StarSnakeStrategy implements SnakeStrategy {

    private final Color color = Color.RED;
    private final HeadType headType = HeadType.SHARP;
    private final TailType tailType = TailType.PIXEL;

    @Override
    public Mono<StartResponse> start(final Mono<StartRequest> startRequest) {
        return Mono.just(StartResponse.builder()
                .color(Color.RED.getColor())
                .headType(HeadType.SHARP.getHeadType())
                .tailType(TailType.PIXEL.getTailType())
                .build());
    }

    @Override
    public Mono<MoveResponse> move(final Mono<MoveRequest> moveRequest) {
        Random random = new Random();
        int selection = random.nextInt(4) + 1;
        if (selection == 1) {
            return Mono.just(MoveResponse.builder()
                    .move(Move.UP.getMove())
                    .build());
        } else if (selection == 2) {
            return Mono.just(MoveResponse.builder()
                    .move(Move.DOWN.getMove())
                    .build());
        } else if (selection == 3) {
            return Mono.just(MoveResponse.builder()
                    .move(Move.LEFT.getMove())
                    .build());
        }
        return Mono.just(MoveResponse.builder()
                .move(Move.RIGHT.getMove())
                .build());
    }

}
