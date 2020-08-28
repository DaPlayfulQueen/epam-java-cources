package com.epam.university.java.core.task038;

/**
 * Interface for building Graph instances.
 */
public interface GraphFactory {
    /**
     * Create new Graph instance with designated amount of nodes.
     * @param nodeCount amount of nodes
     * @return new graph instance
     */
    Graph newInstance(int nodeCount);
}
