package com.snake.service.strategy.star;

import com.snake.model.domain.request.Board;
import com.snake.model.domain.request.Coordinate;
import com.snake.model.domain.request.Snake;
import com.snake.model.domain.response.Move;
import com.snake.model.domain.strategy.star.Edge;
import com.snake.model.domain.strategy.star.Node;
import com.snake.model.domain.strategy.star.NodeBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class StarConfiguration {

    public List<Node> createNodes(final Board board) {
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < board.getHeight(); i++) {
            for(int j = 0; j < board.getWidth(); j++) {
                Node node = NodeBuilder.builder()
                        .coordinate(Coordinate.builder()
                                .x(i)
                                .y(j)
                                .build())
                        .build();
                nodes.add(node);
            }
        }
        return nodes;
    }

    public List<Edge> createEdges(final int width, final int height, final List<Snake> snakes) {
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(j > 0) {
                    int widthIndex = j;
                    Node end = NodeBuilder.builder()
                            .coordinate(Coordinate.builder()
                                    .x(i)
                                    .y(--widthIndex)
                                    .build())
                            .build();
                    Optional<Edge> edge = createReachableEdge(i, j, end, snakes);
                    edge.map(safeEdge -> edges.add(edge.get()));
                }

                if(j != width-1) {
                    int widthIndex = j;
                    Node end = NodeBuilder.builder()
                            .coordinate(Coordinate.builder()
                                    .x(i)
                                    .y(++widthIndex)
                                    .build())
                            .build();
                    Optional<Edge> edge = createReachableEdge(i, j, end, snakes);
                    edge.map(safeEdge -> edges.add(edge.get()));
                }

                if(i > 0) {
                    int heightIndex = i;
                    Node end = NodeBuilder.builder()
                            .coordinate(Coordinate.builder()
                                    .x(--heightIndex)
                                    .y(j)
                                    .build())
                            .build();
                    Optional<Edge> edge = createReachableEdge(i, j, end, snakes);
                    edge.map(safeEdge -> edges.add(edge.get()));
                }

                if(i != height-1) {
                    int heightIndex = i;
                    Node end = NodeBuilder.builder()
                            .coordinate(Coordinate.builder()
                                    .x(++heightIndex)
                                    .y(j)
                                    .build())
                            .build();
                    Optional<Edge> edge = createReachableEdge(i, j, end, snakes);
                    edge.map(safeEdge -> edges.add(edge.get()));
                }
            }
        }
        return edges;
    }

    public static Move getDirection(final Node start, final Node next, final List<Edge> edges) {
        Optional<Edge> edge = edges.stream()
                .parallel()
                .filter(startEdge -> startEdge.getStart().equals(start))
                .filter(endEdge -> endEdge.getEnd().equals(next))
                .findFirst();

        if(edge.isPresent()) {
            if (edge.get().getEnd().getCoordinate().getX() > start.getCoordinate().getX()) {
                log.info("Moving Right");
                return Move.RIGHT;
            } else if (edge.get().getEnd().getCoordinate().getX() < start.getCoordinate().getX()) {
                log.info("Moving Left");
                return Move.LEFT;
            } else if (start.getCoordinate().getY() > edge.get().getEnd().getCoordinate().getY()) {
                log.info("Moving Up");
                return Move.UP;
            } else {
                log.info("Moving Down");
                return Move.DOWN;
            }
        }
        log.info("Moving Default Left");
        return Move.LEFT;
    }

    private Optional<Edge> createReachableEdge(final int x, final int y, final Node end, final List<Snake> snakes) {
        if(!isOtherSnakeInTheWay(end.getCoordinate().getX(), end.getCoordinate().getY(), snakes)) {
            return Optional.of(Edge.builder()
                    .start(NodeBuilder.builder()
                            .coordinate(Coordinate.builder()
                                    .x(x)
                                    .y(y)
                                    .build())
                            .build())
                    .end(end)
                    .length(1)
                    .build());
        }
        return Optional.empty();
    }

    private boolean isOtherSnakeInTheWay(final int x, final int y, final List<Snake> snakes) {
        Optional<Snake> result = snakes.stream()
                .parallel()
                .filter(snake -> isBodyInTheWay(x, y, snake.getBody()))
                .findFirst();
        return result.isPresent();
    }

    private boolean isBodyInTheWay(final int x, final int y, final List<Coordinate> body) {
        Optional<Coordinate> result = body.stream()
                .parallel()
                .filter(coordinate -> coordinate.getX().equals(x) && coordinate.getY().equals(y))
                .findFirst();
        return result.isPresent();
    }

}
