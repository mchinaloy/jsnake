package com.snake.service.strategy.star;

import com.snake.model.domain.request.Coordinate;
import com.snake.model.domain.response.Color;
import com.snake.model.domain.response.HeadType;
import com.snake.model.domain.response.TailType;
import com.snake.model.domain.strategy.star.Node;
import com.snake.model.domain.strategy.star.NodeBuilder;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import com.snake.service.strategy.SnakeStrategy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Getter
public class StarSnakeStrategy implements SnakeStrategy {

    private final StarCache starCache;
    private final Color color = Color.RED;
    private final HeadType headType = HeadType.SHARP;
    private final TailType tailType = TailType.PIXEL;

    public StarSnakeStrategy(StarCache starCache) {
        this.starCache = starCache;
    }

    @Override
    public Mono<StartResponse> start(final Mono<StartRequest> startRequest) {
        return startRequest.map(request -> {
            starCache.setNodes(request.getBoard());
            return StartResponse.builder()
                .color(Color.RED.getColor())
                .headType(HeadType.SHARP.getHeadType())
                .tailType(TailType.PIXEL.getTailType())
                .build();
        });
    }

    @Override
    public Mono<MoveResponse> move(final Mono<MoveRequest> moveRequest) {
        return moveRequest.map(request -> {

            starCache.setEdges(request.getBoard());

            StarRunner aStar = StarRunner.builder()
                    .graph(starCache.getGraph())
                    .build();

            Node start = NodeBuilder.builder()
                    .coordinate(Coordinate.builder()
                            .x(request.getYou().getBody().get(0).getX())
                            .y(request.getYou().getBody().get(0).getY())
                            .build())
                    .build();

            Node end = NodeBuilder.builder()
                    .coordinate(Coordinate.builder()
                            .x(request.getBoard().getFood().get(request.getBoard().getFood().size()-1).getX())
                            .y(request.getBoard().getFood().get(request.getBoard().getFood().size()-1).getY())
                            .build())
                    .build();

            Node node = aStar.run(start, end);

            log.info("Next node to move to={}", node);
            return MoveResponse.builder()
                    .move(StarConfiguration.getDirection(start, node, starCache.getGraph().getEdges()).getMove())
                    .build();
        }).log();
    }

}
