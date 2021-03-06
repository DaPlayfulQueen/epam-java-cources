package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {

    private int x;
    private int y;

    public VertexImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int value) {
        x = value;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int value) {
        y = value;
    }
}
