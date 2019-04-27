package com.snake.model.domain.strategy.star;

import com.snake.model.domain.request.Coordinate;

public class NodeBuilder {

    private Double heuristic;
    private Double distance = Double.MAX_VALUE;
    private Node previous = null;
    private Coordinate coordinate;

    private NodeBuilder() {
    }

    public static NodeBuilder builder() {
        return new NodeBuilder();
    }

    public NodeBuilder heuristic(Double heuristic) {
        this.heuristic = heuristic;
        return this;
    }

    public NodeBuilder distance(Double distance) {
        this.distance = distance;
        return this;
    }

    public NodeBuilder previous(Node previous) {
        this.previous = previous;
        return this;
    }

    public NodeBuilder coordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public Node build() {
        return new Node(heuristic, distance, previous, coordinate);
    }

}
