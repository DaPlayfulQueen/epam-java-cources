package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {

    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        source = source.replaceAll("\\s+", "");

        return source.split(",");
    }
}
