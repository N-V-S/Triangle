package com.epam.task07.main.data.parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RegExTriangleParserTest {

    @Test
    public void testIsValidShouldReturnTrueWhenLineIsValid() {
        //given
        RegExTriangleParser parser = new RegExTriangleParser();
        List<Double> expected = Arrays.asList(0.0, -1.0, 0.0, 5.0, 4.0, 0.0);
        //when
        List<Double> actual = parser.parse("0.0 -1.0 0.0 5.0 4.0 0.0");
        //then
        Assert.assertEquals(expected, actual);
    }
}