package com.epam.task07.main.logic.comparator;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Assert;
import org.junit.Test;

public class IdComparatorTest {

    private static final TriangleObservable FIRST_TRIANGLE = new TriangleObservable(1, new Point(-3, 0), new Point(0, 2), new Point(3, 0));
    private static final TriangleObservable SECOND_TRIANGLE = new TriangleObservable(3, new Point(3, 9), new Point(0, 6), new Point(4, 2));

    private final IdComparator comparator = new IdComparator();

    @Test
    public void testCompareShouldReturnNegativeNumberWhenIdFirstTriangleLessThanIdSecondTriangle() {
        //when
        int actual = comparator.compare(FIRST_TRIANGLE, SECOND_TRIANGLE);
        //then
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testCompareShouldReturnPositiveNumberWhenIdFirstTriangleMoreThanIdSecondTriangle() {
        //when
        int actual = comparator.compare(SECOND_TRIANGLE, FIRST_TRIANGLE);
        //then
        Assert.assertTrue(actual > 0);
    }
}
