package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;


public class Task012Impl implements Task012 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {

        for (GraphAction action:
             actions) {
            action.run(sourceGraph);
        }

        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Stack<WrappedNode> stack = new Stack<>();
        GraphImpl localGraph = (GraphImpl) graph;
        Map<Integer, WrappedNode> wrappedNodes = getWrappedNodes(localGraph.getNodes());

        WrappedNode start = wrappedNodes.get(from);
        stack.push(start);

        while (stack.size() != 0) {
            WrappedNode currentWrapper = stack.pop();

            if (currentWrapper.color == Colors.WHITE) {
                currentWrapper.color = Colors.GREY;
                stack.push(currentWrapper);

                Node node = currentWrapper.node;

                for (Integer adjacentId :
                        node.getAdjacents()) {
                    if (adjacentId == to) {
                        return true;
                    }

                    WrappedNode adjacent = wrappedNodes.get(adjacentId);

                    if (adjacent.color == Colors.WHITE) {
                        stack.push(adjacent);
                    }

                }

            } else {
                currentWrapper.color = Colors.BLACK;
            }

        }

        return false;
    }

    private Map<Integer, WrappedNode> getWrappedNodes(Map<Integer, Node> nodes) {
        Map<Integer, WrappedNode> wrappedNodes = new HashMap<>();
        for (Map.Entry<Integer, Node> entry :
                nodes.entrySet()) {
            wrappedNodes.put(entry.getKey(), new WrappedNode(entry.getValue()));
        }

        return wrappedNodes;
    }

    private static class WrappedNode {
        private Node node;
        Colors color = Colors.WHITE;

        public WrappedNode(Node node) {
            this.node = node;
        }
    }

    private enum Colors {
        BLACK, GREY, WHITE
    }

}
