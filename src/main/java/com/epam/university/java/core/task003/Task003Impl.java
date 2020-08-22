package com.epam.university.java.core.task003;


import com.epam.university.java.core.commons.PlayfulUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


public class Task003Impl implements Task003 {

    @Override
    public String[] invert(String[] source) {

        if (isArgumentInvalid(source)) {
            throw new IllegalArgumentException();
        }

        int arrayLength = source.length;
        String[] result = new String[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            result[i] = source[arrayLength - 1 - i];
        }

        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (isArgumentInvalid(first) || isArgumentInvalid(second)) {
            throw new IllegalArgumentException();
        }

        int resultLength = first.length + second.length;
        int firstArrayLength = first.length;
        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            if (i < firstArrayLength) {
                result[i] = first[i];
            } else {
                result[i] = second[i - firstArrayLength];
            }
        }

        return result;

    }

    @Override
    public int findMax(int[] source) {

        if (isArgumentInvalid(source)) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;

        for (int number : source) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (isArgumentInvalid(source) || condition == null) {
            throw new IllegalArgumentException();
        }

        List<String> resultList = new ArrayList<>();

        for (String string : source) {
            if (condition.isValid(string)) {
                resultList.add(string);
            }
        }

        String[] resultArray = new String[resultList.size()];
        resultList.toArray(resultArray);

        return resultArray;

    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (isArgumentInvalid(source) || isArgumentInvalid(toRemote)) {
            throw new IllegalArgumentException();
        }

        // O(n*n) at max
        List<String> resultList = new LinkedList<>(Arrays.asList(source));

        for (String string : toRemote) {
            resultList.remove(string);
        }

        String[] resultArray = new String[resultList.size()];
        return resultList.toArray(resultArray);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (isArgumentInvalid(source) || operation == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }

        return source;

    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (isArgumentInvalid(source) || operation == null) {
            throw new IllegalArgumentException();
        }

        List<String> tempStringList = new LinkedList<>();

        for (String string :
                source) {
            tempStringList.addAll(Arrays.asList(operation.flatMap(string)));
        }

        Set<Integer> intValuesSet = new HashSet<>();


        for (String string :
                tempStringList) {
            intValuesSet.add(Integer.parseInt(string));
        }

        Integer[] intValues = new Integer[intValuesSet.size()];
        intValuesSet.toArray(intValues);

        PlayfulUtils.quickSort(intValues, 0, intValues.length - 1);

        String[] result = new String[intValues.length];

        for (int i = 0; i < intValues.length; i++) {
            result[i] = String.valueOf(intValues[i]);
            System.out.println(result[i]);
        }


        return result;

    }

    private boolean isArgumentInvalid(String[] argument) {
        return argument == null;
    }

    private boolean isArgumentInvalid(int[] argument) {
        return argument == null;
    }

}
