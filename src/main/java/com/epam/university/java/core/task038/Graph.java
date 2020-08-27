package com.epam.university.java.core.task038;

/**
 * Undirected graph.
 */
public interface Graph {

    /**
     * Create node with given id, x and y coordinates
     * @param id node id
     * @param x x coordinate
     * @param y y coordinate
     */

    void createNode(int id, int x, int y);

    /**
     * Add connection directed from source node to target node
     * @param fromId id of source node
     * @param toId id of target node
     */
    void connectNodes(int fromId, int toId);

}
