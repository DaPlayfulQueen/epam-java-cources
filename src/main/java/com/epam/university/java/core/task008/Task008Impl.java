package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {

    @Override
    public boolean isValid(String sourceString) {
        Stack stack = new Stack(sourceString.length());

        for (int i = 0; i < sourceString.length(); i++) {
            char currChar = sourceString.charAt(i);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.push(currChar);
            }
            if (currChar == ')') {
                char popChar = stack.pop();
                if (popChar != '(') {
                    return false;
                }
            }
            if (currChar == '}') {
                char popChar = stack.pop();
                if (popChar != '{') {
                    return false;
                }
            }
            if (currChar == ']') {
                Character popChar = stack.pop();
                if (popChar == null || popChar != '[') {
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

}
