package com.snake.service.strategy.star;

import com.snake.model.domain.request.Coordinate;
import com.snake.model.domain.strategy.star.Edge;
import com.snake.model.domain.strategy.star.Graph;
import com.snake.model.domain.strategy.star.Node;
import com.snake.model.domain.strategy.star.NodeBuilder;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

@Slf4j
@Builder
public class StarRunner {

    private final Graph graph;
    private final List<Node> searched = new ArrayList<>();
    private final PriorityQueue<Node> unsearched = new PriorityQueue<>();

    public Node run(final Node start, final Node end) {
        log.info("Running A* search");

        Node startWithDistanceAndHeuristic = NodeBuilder.builder()
                .distance(0.0)
                .heuristic(Node.distanceFrom(start, end))
                .coordinate(Coordinate.builder()
                        .x(start.getCoordinate().getX())
                        .y(start.getCoordinate().getY())
                        .build())
                .build();

        Node current;

        //Add @param start to the queue
        unsearched.add(startWithDistanceAndHeuristic);

        while(!unsearched.isEmpty()) {
            current = unsearched.poll();
            if(current.equals(end)) {
                log.info("Shortest path found");
                Stack<Node> stack = new Stack<>();
                log.info("Total distance traveled: " + end.getDistance());
                int hop = 0;
                while(current.getPrevious() != null && !current.getPrevious().equals(start)) {
                    current = current.getPrevious();
                    stack.push(current);
                    log.info(++hop + ": " + current);
                }

                log.info("Stack size={}", stack.capacity());

                return stack.isEmpty() ? current : stack.pop();
            }
            searched.add(current);
            updateNeighbor(current, end);
        }
        log.info("Shortest path between " + start + " and " + end + " was not found.");
        return startWithDistanceAndHeuristic;
    }

    /*
     * @param current node whose neighbors are to be checked/updated.
     * @param destination node which heuristics will be calculated from (AKA distance from @param destination)
     */
    public void updateNeighbor(final Node current, final Node destination) {
        List<Node> neighbors = Graph.getNeighbors(graph.getEdges(), current);
        //distance is the current node's distance to start
        Double distance = current.getDistance();
        for(Node neighbor : neighbors) {
            //temp is the distance from current node to a neighbor
            Double temp = Graph.getDistanceFrom(graph.getEdges(), current, neighbor);
            //If searched already contains neighbor, no need to double check. Continue in loop.
            if(!searched.contains(neighbor)) {
                if(distance + temp < neighbor.getDistance()) {
                    //Shorter path has been found. Update neighboring node.

                    Node node = NodeBuilder.builder()
                            .coordinate(Coordinate.builder()
                                    .x(neighbor.getCoordinate().getX())
                                    .y(neighbor.getCoordinate().getY())
                                    .build())
                            .heuristic(Node.distanceFrom(neighbor, destination))
                            .distance(distance + temp)
                            .previous(current)
                            .build();

                    //Allow neighbor to be searched through by adding it to the unsearched queue.
                    unsearched.add(node);
                }
            }
        }
    }

}
