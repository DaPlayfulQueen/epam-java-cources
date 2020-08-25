package com.epam.university.java.core.task009;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) throws IOException {
        Set<String> uniqueWords = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(sourceFile, StandardCharsets.UTF_8));




        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String[] wordsFromLine = currentLine.trim().split("[ ]+");



            for (int i = 0; i < wordsFromLine.length; i++) {
                String wordFromLine = wordsFromLine[i]
                        .toLowerCase().replaceAll("[^A-Za-z0-9’]", "");
                if (!wordFromLine.equals("")) {
                    uniqueWords.add(wordFromLine);
                }

            }
        }

        for (String string:
             uniqueWords) {
            System.out.println("Word " + string);
        }


        return uniqueWords;
    }
}
