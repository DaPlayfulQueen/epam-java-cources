package com.epam.university.java.core.task012;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private int id;
    private Set<Integer> adjacents = new HashSet<>();

    public Node(int id) {
        this.id = id;
    }

    public void addAdjacent(Integer adjacentId) {
        adjacents.add(adjacentId);
    }

    public Set<Integer> getAdjacents() {
        return adjacents;
    }

    public boolean hasAdjacent(Integer adjacentId) {
        return adjacents.contains(adjacentId);
    }

    public void removeAdjacent(Integer adjacentId) {
        adjacents.remove(adjacentId);
    }

}