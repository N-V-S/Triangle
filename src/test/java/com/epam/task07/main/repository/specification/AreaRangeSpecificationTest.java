package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

public class AreaRangeSpecificationTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
    private final AreaRangeSpecification specification = new AreaRangeSpecification(calculator, 5.0, 12.0);

    @Test
    public void testIsSpecifiedShouldReturnTrueWhenTriangleAreaWithinRange() {
        //given
        Mockito.when(calculator.calculateArea(Mockito.any(Triangle.class))).thenReturn(9.0);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalseWhenTriangleAreaOutOfRange() {
        //given
        Mockito.when(calculator.calculateArea(Mockito.any(Triangle.class))).thenReturn(19.0);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertFalse(actual);
    }
}