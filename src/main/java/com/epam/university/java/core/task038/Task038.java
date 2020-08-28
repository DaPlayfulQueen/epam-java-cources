package com.epam.university.java.core.task038;

import java.util.Collection;

/**
 * Directed weighted graph.
 * Graph is node-centric and all of its nodes located on the 1st quadrant
 * of coordinate plane (x >= 0, y >= 0).
 */
public interface Task038 {

    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     *
     * @param sourceGraph initial graph instance
     * @param actions     collection of actions
     * @return updated graph instance
     */
    Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions);

    /**
     * Find the path with minimum possible sum of its edges weights.
     * Path must contain source and target node.
     * If path doesn't exist, return empty collection.
     *
     * @param graph   graph instance
     * @param startId is id of source node
     * @param endId   is id of target node
     * @return collection of nodes from source to target with minimum possible sum of edge weights.
     */
    Collection<Node> getShortestPath(Graph graph, int startId, int endId);

}
