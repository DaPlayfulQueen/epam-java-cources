package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) throws IOException {

        HashMap<String, Integer> wordsFrequency = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(source, StandardCharsets.UTF_8));

        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String[] wordsFromLine = currentLine.trim().split("[ ]+");


            for (int i = 0; i < wordsFromLine.length; i++) {
                wordsFromLine[i] = wordsFromLine[i]
                        .toLowerCase().replaceAll("[^A-Za-z0-9’]", "");

                int count;
                if (wordsFrequency.containsKey(wordsFromLine[i])) {
                    count = wordsFrequency.get(wordsFromLine[i]) + 1;
                } else {
                    count = 1;
                }
                wordsFrequency.put(wordsFromLine[i], count);

            }
        }

        return wordsFrequency;
    }
}
