package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task007Impl implements Task007 {

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {

        if (isArgumentInvalid(first) || isArgumentInvalid(second)) {
            throw new IllegalArgumentException();
        }

        int resultLength = first.size() + second.size() - 1;
        Integer[] result = new Integer[resultLength];

        Integer[] firstCoeffs = new Integer[first.size()];
        first.toArray(firstCoeffs);
        Integer[] secondCoeffs = new Integer[second.size()];
        second.toArray(secondCoeffs);

        for (int i = firstCoeffs.length - 1; i >= 0; i--) {
            int coefficient1 = firstCoeffs[i];

            for (int j = secondCoeffs.length - 1; j >= 0; j--) {
                int coefficient2 = secondCoeffs[j];
                int power = i + j;
                int addition = coefficient1 * coefficient2;

                if (result[power] == null) {
                    result[power] = 0;
                }

                result[power] += addition;
            }

        }

        int sum = 0;
        for (Integer integer : result) {
            sum += integer;
        }
        if (sum == 0) {
            ArrayList<Integer> emptyResult = new ArrayList<>();
            emptyResult.add(0);
            return emptyResult;
        }

        return new ArrayList<>(Arrays.asList(result));
    }

    private boolean isArgumentInvalid(Object argument) {
        return argument == null;
    }

}
