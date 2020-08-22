package com.epam.university.java.core.task004;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {

        if (isArgumentInvalid(first) || isArgumentInvalid(second)) {
            throw new IllegalArgumentException();
        }

        List<String> firstList = new LinkedList<>(Arrays.asList(first));
        List<String> secondList = new LinkedList<>(Arrays.asList(second));
        List<String> resultList = new LinkedList<>();

        Iterator<String> i1 = firstList.iterator();
        while (i1.hasNext()) {
            String string1 = i1.next();
            Iterator<String> i2 = secondList.iterator();
            while (i2.hasNext()) {
                String string2 = i2.next();

                if (string1.equals(string2)) {
                    i1.remove();
                    i2.remove();
                    resultList.add(string1);
                }

            }
        }

        String[] resultArray = new String[resultList.size()];

        return resultList.toArray(resultArray);

    }

    @Override
    public String[] union(String[] first, String[] second) {

        if (isArgumentInvalid(first) || isArgumentInvalid(second)) {
            throw new IllegalArgumentException();
        }

        Set<String> resultSet = new LinkedHashSet<>();

        resultSet.addAll(Arrays.asList(first));
        resultSet.addAll(Arrays.asList(second));

        String[] result = new String[resultSet.size()];
        resultSet.toArray(result);


        return result;

    }

    public static boolean isArgumentInvalid(String[] argument) {
        return argument == null;
    }


}
