package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class PerimeterRangeSpecificationTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
    private final PerimeterRangeSpecification specification = new PerimeterRangeSpecification(calculator, 5.0, 12.0);

    @Test
    public void testIsSpecifiedShouldReturnTrueWhenTrianglePerimeterWithinRange() {
        //given
        Mockito.when(calculator.calculatePerimeter(Mockito.any(Triangle.class))).thenReturn(9.0);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalseWhenTrianglePerimeterOutOfRange() {
        //given
        Mockito.when(calculator.calculatePerimeter(Mockito.any(Triangle.class))).thenReturn(19.0);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertFalse(actual);
    }
}