package com.snake.model.domain.strategy.star;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Graph {

    private final List<Node> nodes;
    private final List<Edge> edges;

    public static List<Node> getNeighbors(final List<Edge> edges, final Node node) {
        List<Node> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getStart().equals(node)) {
                neighbors.add(edge.getEnd());
            }
        }
        return neighbors;
    }

    public static Double getDistanceFrom(final List<Edge> edges, final Node start, final Node end) {
        for (Edge e : edges) {
            if (e.getStart().equals(start) && e.getEnd().equals(end)) {
                return e.getLength();
            }
        }
        return null;
    }

}
