package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Collection;
import static java.lang.Math.pow;

public class Path {

    private ArrayList<Node> path;

    public Path(Collection<Node> path) {
        this.path = new ArrayList<>(path);
    }

    public int calculateDistance() {
        double distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            distance += distanceBetweenNodes(path.get(i), path.get(i + 1));
        }

        return (int) distance;
    }

    public boolean isExist() {
        return !path.isEmpty();
    }

    private double distanceBetweenNodes(Node from, Node to) {
        int x1 = from.getX();
        int y1 = from.getY();
        int x2 = to.getX();
        int y2 = to.getY();
        return Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }

}
