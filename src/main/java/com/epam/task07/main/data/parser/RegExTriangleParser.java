package com.epam.task07.main.data.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTriangleParser implements TriangleParser {

    private static final String regex = "-?\\d+\\.?\\d+";

    public List<Double> parse(String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<Double> pointCoordinates = new ArrayList<Double>();
        while (matcher.find()) {
            String foundString = matcher.group();
            double coordinate = Double.parseDouble(foundString);
            pointCoordinates.add(coordinate);
        }
        return pointCoordinates;
    }
}