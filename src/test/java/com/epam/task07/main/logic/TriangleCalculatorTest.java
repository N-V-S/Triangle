package com.epam.task07.main.logic;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.model.TriangleAngles;
import com.epam.task07.main.model.TriangleSides;
import org.junit.Assert;
import org.junit.Test;

public class TriangleCalculatorTest {

    private final TriangleCalculator calculator = new TriangleCalculator();
    private static final double DELTA = 0.001;

    private static final Triangle ISOSCELES_OBTUSE_TRIANGLE = new Triangle(new Point(-3, 0), new Point(0, 2), new Point(3, 0));
    private static final Triangle EQUILATERAL_ACUTE_TRIANGLE = new Triangle(new Point(0, 0), new Point(0.5, 0.866), new Point(1, 0));
    private static final Triangle RIGHT_TRIANGLE = new Triangle(new Point(3, 9), new Point(0, 6), new Point(4, 2));

    @Test
    public void testIsIsoscelesShouldReturnTrueWhenTriangleIsIsosceles() {
        //when
        boolean actual = calculator.isIsosceles(ISOSCELES_OBTUSE_TRIANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsIsoscelesShouldReturnFalseWhenTriangleIsNotIsosceles() {
        //when
        boolean actual = calculator.isIsosceles(RIGHT_TRIANGLE);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsEquilateralShouldReturnTrueWhenTriangleIsEquilateral() {
        //when
        boolean actual = calculator.isEquilateral(EQUILATERAL_ACUTE_TRIANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsEquilateralShouldReturnFalseWhenTriangleIsNotEquilateral() {
        //when
        boolean actual = calculator.isEquilateral(ISOSCELES_OBTUSE_TRIANGLE);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsRightShouldReturnTrueWhenTriangleIsRight() {
        //when
        boolean actual = calculator.isRight(RIGHT_TRIANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRightShouldReturnFalseWhenTriangleIsNotRight() {
        //when
        boolean actual = calculator.isRight(EQUILATERAL_ACUTE_TRIANGLE);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsAcuteShouldReturnTrueWhenTriangleIsAcute() {
        //when
        boolean actual = calculator.isAcute(EQUILATERAL_ACUTE_TRIANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsAcuteShouldReturnFalseWhenTriangleIsNotAcute() {
        //when
        boolean actual = calculator.isAcute(ISOSCELES_OBTUSE_TRIANGLE);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsObtuseShouldReturnTrueWhenTriangleIsObtuse() {
        //when
        boolean actual = calculator.isObtuse(ISOSCELES_OBTUSE_TRIANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsObtuseShouldReturnFalseWhenTriangleIsNotObtuse() {
        //when
        boolean actual = calculator.isObtuse(EQUILATERAL_ACUTE_TRIANGLE);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testCalculateAreaShouldCalculateTriangleAreaWhenTriangleIsValid() {
        //when
        double actual = calculator.calculateArea(RIGHT_TRIANGLE);
        //then
        Assert.assertEquals(12, actual, DELTA);
    }

    @Test
    public void testCalculatePerimeterShouldCalculateTrianglePerimeterWhenTriangleIsValid() {
        //when
        double actual = calculator.calculatePerimeter(RIGHT_TRIANGLE);
        //then
        Assert.assertEquals(16.97, actual, DELTA);
    }

    @Test
    public void testGetAllSideShouldReturnAllSideWhenTriangleIsValid() {
        TriangleSides expected = new TriangleSides(1, 1, 1);
        //when
        TriangleSides actual = calculator.getAllSide(EQUILATERAL_ACUTE_TRIANGLE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDegreesAnglesShouldReturnAllDegreesAnglesWhenTriangleIsValid() {
        TriangleAngles expected = new TriangleAngles(60, 60, 60);
        //when
        TriangleAngles actual = calculator.getAllDegreesAngles(EQUILATERAL_ACUTE_TRIANGLE);
        //then
        Assert.assertEquals(expected, actual);
    }
}