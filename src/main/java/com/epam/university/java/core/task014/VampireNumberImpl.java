package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {

    private int multiplication;
    private int first;
    private int second;

    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return (first + second + multiplication);
    }

    @Override
    public int getMultiplication() {
        return multiplication;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getSecond() {
        return second;
    }
}
