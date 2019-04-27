package com.snake.service.strategy.star;

import com.snake.model.domain.request.Board;
import com.snake.model.domain.strategy.star.Edge;
import com.snake.model.domain.strategy.star.Graph;
import com.snake.model.domain.strategy.star.Node;

import java.util.List;

public class StarCache {

    private final StarConfiguration starConfiguration;

    private List<Node> nodes;
    private List<Edge> edges;

    public StarCache(StarConfiguration starConfiguration) {
        this.starConfiguration = starConfiguration;
    }

    public void setNodes(final Board board) {
        this.nodes = starConfiguration.createNodes(board);
    }

    public void setEdges(final Board board) {
        this.edges = starConfiguration.createEdges(board.getWidth(),
                board.getHeight(), board.getSnakes());
    }

    public Graph getGraph() {
        return Graph.builder()
                .nodes(nodes)
                .edges(edges)
                .build();
    }

}
