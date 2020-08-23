package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {

        if (isArgumentInvalid(digits)) {
            throw new IllegalArgumentException();
        }

        PiHolderImpl piHolder = new PiHolderImpl();
        double minDifference = 1;

        int rangeStart = (int) Math.pow(10, digits - 1);
        int rangeEnd = (int) Math.pow(10, digits) - 1;

        for (int numerator = rangeStart; numerator < rangeEnd; numerator++) {
            int upperBound = numerator / 3;
            int lowerBound = (int) Math.ceil((double) numerator / 4);

            if (upperBound < rangeStart) {
                continue;
            }

            lowerBound = Math.max(lowerBound, rangeStart);

            for (int denominator = lowerBound; denominator <= upperBound; denominator++) {
                double difference = Math.abs(((double) numerator / (double) denominator) - Math.PI);
                if (minDifference > difference) {
                    minDifference = difference;
                    piHolder.setFirst(numerator);
                    piHolder.setSecond(denominator);
                }
            }
        }

        return piHolder;
    }

    private boolean isArgumentInvalid(int argument) {
        return argument <= 0 || argument > 10;
    }

}
