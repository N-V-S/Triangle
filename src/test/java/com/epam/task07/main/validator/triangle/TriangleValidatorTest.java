package com.epam.task07.main.validator.triangle;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TriangleValidatorTest {

    private final static List<Double> TRIANGLE_POINT_COORDINATES = Arrays.asList(0.0, -1.0, 0.0, 5.0, 4.0, 0.0);
    private final static List<Double> LINE_POINT_COORDINATES = Arrays.asList(0.0, -1.0, 1.0, -1.0, 4.0, -1.0);

    public final TriangleValidator validator = new TriangleValidator();

    @Test
    public void testArePointsCollinearShouldReturnTrueWhenPointsAreCollinear() {
        //when
        boolean actual = validator.arePointsCollinear(LINE_POINT_COORDINATES);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testArePointsCollinearShouldReturnFalseWhenPointsAreNotCollinear() {
        //when
        boolean actual = validator.arePointsCollinear(TRIANGLE_POINT_COORDINATES);
        //then
        Assert.assertFalse(actual);
    }
}