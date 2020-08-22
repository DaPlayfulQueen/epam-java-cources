package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public String map(String source) {

        if (source == null) {
            throw new IllegalArgumentException();
        }

        stringBuilder.delete(0, stringBuilder.length()).append(source);
        return stringBuilder.reverse().toString();
    }
}
