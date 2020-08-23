package com.epam.university.java.core.task008;

public class Stack {

    private int currentIndex = -1;
    private Character[] stackArray;
    private Character top;

    public Stack(int maxLength) {
        stackArray = new Character[maxLength];
    }

    public void push(Character item) {
        stackArray[++currentIndex] = item;
        top = item;
    }

    /**
     * I don't know why checker wants a javadoc here.
     *
     * @return popped value
     */
    public Character pop() {
        if (currentIndex == -1) {
            return null;
        }

        stackArray[currentIndex--] = null;
        Character value = top;
        top = currentIndex >= 0 ? stackArray[currentIndex] : null;
        return value;
    }

    public boolean isEmpty() {
        return currentIndex == -1;
    }

    public Character peek() {
        return top;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
