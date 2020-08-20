package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {

    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (isArgumentInvalid(firstString) || isArgumentInvalid(secondString)) {
            throw new IllegalArgumentException();
        }

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (isArgumentInvalid(sourceString) || isArgumentInvalid(number)) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            return sourceString;
        }

        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (isArgumentInvalid(sourceString) || isArgumentInvalid(separator)) {
            throw new IllegalArgumentException();
        }

        return sourceString.split(separator)[0];
    }

    @Override
    public String right(String sourceString, int number) {
        if (isArgumentInvalid(sourceString) || isArgumentInvalid(number)) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            return sourceString;
        }

        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (isArgumentInvalid(sourceString) || isArgumentInvalid(separator)) {
            throw new IllegalArgumentException();
        }

        String[] splitString = sourceString.split(separator);

        return splitString[splitString.length - 1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (isArgumentInvalid(sourceString) || isArgumentInvalid(split)) {
            throw new IllegalArgumentException();
        }
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (isArgumentInvalid(sourceCollection) || isArgumentInvalid(glue) || sourceCollection.length == 0) {
            throw new IllegalArgumentException();
        }

        return String.join(glue, sourceCollection);

    }

    private boolean isArgumentInvalid(String stringArgument) {
        return stringArgument == null;
    }

    private boolean isArgumentInvalid(int intArgument) {
        return intArgument < 0;
    }

    private boolean isArgumentInvalid(String[] arrayArgument) {
        boolean arrayNull = arrayArgument == null;

        if (arrayNull) {
            return true;
        }

        //extra check for string nullability
        for (String string :
                arrayArgument) {
            if (string == null) {
                return true;
            }
        }

        return false;
    }
}
