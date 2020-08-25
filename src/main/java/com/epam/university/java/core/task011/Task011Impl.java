package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {

        if (isArgumentInvalid(collection)) {
            throw new IllegalArgumentException();
        }

        int inCircle = collection.length;
        int index = 0;

        while (true) {
            if (inCircle == 1) {
                return collection[0];
            }
            collection[index] = null;
            moveArrayElements(collection, index, inCircle - 1);
            inCircle--;
            index = (index + 1) % inCircle;

        }
    }

    @Override
    public String getLastName(ArrayList<String> collection) {

        if (isArgumentInvalid(collection)) {
            throw new IllegalArgumentException();
        }

        int index = 0;

        while (collection.size() != 1) {
            collection.remove(index);
            index = (index + 1) % collection.size();
        }

        return collection.get(0);
    }

    // I'm sorry for this. I'll optimize it later
    @Override
    public String getLastName(LinkedList<String> collection) {
        if (isArgumentInvalid(collection)) {
            throw new IllegalArgumentException();
        }

        int index = 0;

        while (collection.size() != 1) {
            collection.remove(index);
            index = (index + 1) % collection.size();
        }

        return collection.get(0);
    }

    private void moveArrayElements(String[] array, int startPosition, int endPosition) {

        String firstElement = array[startPosition];
        startPosition++;

        if (endPosition + 1 - startPosition >= 0) {
            System.arraycopy(array, startPosition, array, startPosition - 1,
                    endPosition + 1 - startPosition);
        }
        array[endPosition] = firstElement;

    }


    private boolean isArgumentInvalid(String[] collection) {
        return collection.length == 0;
    }

    private boolean isArgumentInvalid(Collection<String> collection) {
        return collection.size() == 0;
    }


}
