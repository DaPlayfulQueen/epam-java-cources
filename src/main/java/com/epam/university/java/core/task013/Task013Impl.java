package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction action :
                actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {

        ((FigureImpl) figure).sortVertices();
        ArrayList<Vertex> vertices = (ArrayList<Vertex>) figure.getVertexes();

        Vertex a;
        Vertex b;
        Vertex c;

        int direction = 0;

        for (int i = 0; i < vertices.size(); i++) {
            a = vertices.get(i);
            Vertex tmp = vertices.get((i + 1) % vertices.size());
            b = new VertexImpl(tmp.getX() - a.getX(), tmp.getY() - a.getY());
            c = vertices.get((i + 2) % vertices.size());

            if (i == 0) {
                direction = getDirection(a, b, c);
            } else {
                int newDirection = getDirection(a, b, c);

                if ((newDirection > 0 && direction < 0) || (newDirection < 0 && direction > 0)) {
                    return false;
                }
            }

        }

        return true;
    }

    private int getDirection(Vertex a, Vertex b, Vertex c) {
        return c.getX() * b.getY() - c.getY() * b.getX()
                + b.getX() * a.getY() - b.getY() * a.getX();
    }

}
