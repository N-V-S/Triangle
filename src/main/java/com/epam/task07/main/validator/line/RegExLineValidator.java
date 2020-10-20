package com.epam.task07.main.validator.line;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExLineValidator implements LineValidator {

    private static final String regex = "(-?\\d+\\.?\\d+\\s+){5}(-?\\d+\\.?\\d+\\s*)";

    public boolean isValid(String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}