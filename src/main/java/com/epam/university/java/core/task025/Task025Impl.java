package com.epam.university.java.core.task025;

import com.epam.university.java.core.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        int count = 0;
        new Validator().vaildate(sourceMessage);
        final String sos = "SOS";
        Pattern p = Pattern.compile("\\w{3}");
        Matcher m = p.matcher(sourceMessage);
        while (m.find()) {
            String s = m.group(0);
            for (int i = 0; i < sos.length(); i++) {
                if (s.charAt(i) != sos.charAt(i)) {
                    ++count;
                }
            }
        }
        return count;
    }
}
