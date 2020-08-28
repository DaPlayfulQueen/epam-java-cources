package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import static java.lang.Math.pow;

public class FigureImpl implements Figure {

    private ArrayList<Vertex> vertecies;

    public FigureImpl(int vertexCount) {
        vertecies = new ArrayList<>(vertexCount);
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertecies.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertecies;
    }

    /**
     * Sorts vertices in order to represent figure.
     */

    public void sortVertices() {
        HashSet<Vertex> oldVertices = new HashSet<>(vertecies);
        ArrayList<Vertex> sortedVertices = new ArrayList<>(vertecies.size());


        Iterator<Vertex> iterator = oldVertices.iterator();
        sortedVertices.add(iterator.next());
        iterator.remove();

        while (!oldVertices.isEmpty()) {

            Vertex currentVertex = sortedVertices.get(sortedVertices.size() - 1);

            double currentDistance = Double.MAX_VALUE;
            Vertex currentClosest = null;
            for (Vertex vertex :
                    oldVertices) {
                double distance = getDistance(vertex, currentVertex);
                if (distance < currentDistance) {
                    currentClosest = vertex;
                    currentDistance = distance;
                }
            }
            sortedVertices.add(currentClosest);
            oldVertices.remove(currentClosest);

        }

        vertecies = sortedVertices;

    }

    public double getDistance(Vertex v1, Vertex v2) {
        return Math.sqrt(pow(v1.getX() - v2.getX(), 2) + pow(v1.getY() - v2.getY(), 2));
    }

}
