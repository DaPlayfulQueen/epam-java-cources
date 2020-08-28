package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

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
}
