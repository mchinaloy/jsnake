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
import org.springframework.util.StopWatch;
import reactor.core.publisher.Mono;

import java.util.Random;

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
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
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

            Node end = getEnd(request);

            Node node = aStar.run(start, end);

            stopWatch.stop();

            log.info("Time taken: " + stopWatch.prettyPrint());

            log.info("Next node to move to={}", node);
            return MoveResponse.builder()
                    .move(StarConfiguration.getDirection(start, node, starCache.getGraph().getEdges()).getMove())
                    .build();
        }).log();
    }

    private Node getEnd(MoveRequest moveRequest) {
        Coordinate food = getNearestFood(moveRequest);
        if(food == null) {
            Random random = new Random();
            int x = random.nextInt(moveRequest.getBoard().getWidth());
            int y = random.nextInt(moveRequest.getBoard().getHeight());
            return NodeBuilder.builder()
                    .coordinate(Coordinate.builder()
                            .x(x)
                            .y(y)
                            .build())
                    .build();
        }
        return NodeBuilder.builder()
                .coordinate(Coordinate.builder()
                        .x(food.getX())
                        .y(food.getY())
                        .build())
                .build();
    }

    private Coordinate getNearestFood(MoveRequest moveRequest) {
        if(moveRequest.getBoard().getFood().isEmpty()) {
            return null;
        }
        Coordinate nearestFood = moveRequest.getBoard().getFood().get(0);
        double nearestFoodDistance = 0;

        int headX = moveRequest.getYou().getBody().get(0).getX();
        int headY = moveRequest.getYou().getBody().get(0).getY();

        for(int i = 0; i < moveRequest.getBoard().getFood().size(); i++) {
            Coordinate food = moveRequest.getBoard().getFood().get(i);
            int foodX = food.getX();
            int foodY = food.getY();
            double foodDistance = Math.sqrt((foodY - headY) * (foodY - headY) + (foodX - headX) * (foodX - headX));
            if(foodDistance < nearestFoodDistance) {
                nearestFoodDistance = foodDistance;
                nearestFood = food;
            }
        }
        return nearestFood;
    }

}
