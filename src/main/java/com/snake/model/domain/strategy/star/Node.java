package com.snake.model.domain.strategy.star;

import com.snake.model.domain.request.Coordinate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@EqualsAndHashCode(of = "coordinate")
public class Node implements Comparable<Node> {

    private final Double heuristic;
    private final Double distance;
    private final Node previous;
    private final Coordinate coordinate;

    public Node(Double heuristic, Double distance, Node previous, Coordinate coordinate) {
        this.heuristic = heuristic;
        this.distance = distance;
        this.previous = previous;
        this.coordinate = coordinate;
    }

    @Override
    public int compareTo(Node node) {
        return Double.compare(heuristic + distance, node.heuristic + node.distance);
    }

    public static Double distanceFrom(Node node1, Node node2) {
        return Math.sqrt((node1.coordinate.getX() - node2.coordinate.getX()) * (node1.coordinate.getX() - node2.coordinate.getX())
                + (node1.coordinate.getY() - node2.coordinate.getY()) * (node1.coordinate.getY() - node2.coordinate.getY()));
    }

}
