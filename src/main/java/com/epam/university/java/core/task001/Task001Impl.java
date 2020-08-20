package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {
        if (isArgumentInvalid(firstNumber) || isArgumentInvalid(secondNumber)) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if (isArgumentInvalid(firstNumber) || isArgumentInvalid(secondNumber)) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if (isArgumentInvalid(firstNumber) || isArgumentInvalid(secondNumber)) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if (isArgumentInvalid(firstNumber) || isArgumentInvalid(secondNumber)) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
    }

    private boolean isArgumentInvalid(String stringArgument) {
        return stringArgument == null || stringArgument.trim().equals("");
    }

}
