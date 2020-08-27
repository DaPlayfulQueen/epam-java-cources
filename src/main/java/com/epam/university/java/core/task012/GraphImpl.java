package com.epam.university.java.core.task012;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class GraphImpl implements Graph {

    private Map<Integer, Node> nodes = new HashMap<>();

    @Override
    public void createEdge(int from, int to) {

        Node nodeFrom = nodes.get(from);
        Node nodeTo = nodes.get(to);
        if (nodeFrom == null) {
            nodeFrom = new Node(from);
            nodes.put(from, nodeFrom);
        }
        nodeFrom.addAdjacent(to);

        if (nodeTo == null) {
            nodeTo = new Node(to);
            nodes.put(to, nodeTo);
        }
        nodeTo.addAdjacent(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Node node = nodes.get(from);

        if (node == null) {
            return false;
        }

        return node.hasAdjacent(to);

    }

    @Override
    public void removeEdge(int from, int to) {
        Node nodeFrom = nodes.get(from);
        Node nodeTo = nodes.get(to);

        nodeFrom.removeAdjacent(to);
        nodeTo.removeAdjacent(from);

    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return nodes.get(from).getAdjacents();
    }

    public Node getNode(Integer nodeId) {
        return nodes.get(nodeId);
    }

    public Map<Integer, Node> getNodes() {
        return nodes;
    }
}
