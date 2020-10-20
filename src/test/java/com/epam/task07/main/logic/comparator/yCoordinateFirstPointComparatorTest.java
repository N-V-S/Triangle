package com.epam.task07.main.logic.comparator;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Assert;
import org.junit.Test;

public class yCoordinateFirstPointComparatorTest {

    private static final TriangleObservable FIRST_TRIANGLE = new TriangleObservable(1, new Point(-3, 0), new Point(0, 2), new Point(3, 0));
    private static final TriangleObservable SECOND_TRIANGLE = new TriangleObservable(3, new Point(3, 9), new Point(0, 6), new Point(4, 2));
    private static final TriangleObservable THIRD_TRIANGLE = new TriangleObservable(2, new Point(0, 0), new Point(0.5, 0.866), new Point(1, 0));

    private final yCoordinateFirstPointComparator comparator = new yCoordinateFirstPointComparator();

    @Test
    public void testCompareShouldReturnNegativeNumberWhenYCoordinateFirstPointFirstTriangleLessThanYCoordinateFirstPointSecondTriangle() {
        //when
        int actual = comparator.compare(FIRST_TRIANGLE, SECOND_TRIANGLE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenYCoordinateFirstPointFirstTriangleEqualsYCoordinateFirstPointSecondTriangle() {
        //when
        int actual = comparator.compare(FIRST_TRIANGLE, THIRD_TRIANGLE);
        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCompareShouldReturnPositiveNumberWhenYCoordinateFirstPointFirstTriangleMoreThanYCoordinateFirstPointSecondTriangle() {
        //when
        int actual = comparator.compare(SECOND_TRIANGLE, THIRD_TRIANGLE);
        //then
        Assert.assertTrue(actual > 0);
    }
}
