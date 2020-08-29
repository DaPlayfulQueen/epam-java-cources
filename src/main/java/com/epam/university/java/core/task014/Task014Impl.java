package com.epam.university.java.core.task014;

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Arrays;


public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Set<VampireNumber> vampireNumbers = new HashSet<>();
        Set<Integer> multiplication = new HashSet<>();

        VampireNumberFactory factory = new VampireNumberFactoryImpl();

        for (int i = 10; i < 99; i++) {
            for (int j = 10; j < 99; j++) {
                if (isVampire(i, j)) {
                    if (!multiplication.contains(i * j)) {
                        vampireNumbers.add(factory.newInstance(i * j, i, j));
                        multiplication.add(i * j);
                    }
                }
            }
        }

        LinkedList<VampireNumber> sortedNumbers = new LinkedList<>(vampireNumbers);
        sortedNumbers.sort(Comparator.comparingInt(VampireNumber::getMultiplication));

        return vampireNumbers;
    }


    private boolean isVampire(int first, int second) {
        int multiplication = first * second;

        if (multiplication < 1000) {
            return false;
        }

        String resultString = String.valueOf(multiplication);
        LinkedList<Character> resultChars = new LinkedList<>(Arrays.asList(
                resultString.charAt(0),
                resultString.charAt(1),
                resultString.charAt(2),
                resultString.charAt(3)
        ));
        LinkedList<Character> numberChars = new LinkedList<>(Arrays.asList(
                String.valueOf(first).charAt(0),
                String.valueOf(first).charAt(1),
                String.valueOf(second).charAt(0),
                String.valueOf(second).charAt(1)
        ));

        int zeroCount = 0;

        for (Character character :
                resultChars) {
            if (character == '0') {
                zeroCount++;
                if (zeroCount == 2) {
                    return false;
                }
            }

            if (!numberChars.contains(character)) {
                return false;
            } else {
                numberChars.remove(character);
            }

        }
        return true;
    }

}
