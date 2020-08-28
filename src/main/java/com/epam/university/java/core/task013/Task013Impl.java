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

        Collection<Vertex> vertices = figure.getVertexes();

        if (vertices.size() < 3) {
            return false;
        }

        Point a;
        Point b;
        Point c;

        for (int i = 0; i < vertices.size(); i++) {
            
        }



        return false;
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
