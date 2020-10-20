package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class RightTriangleSpecificationTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
    private final RightTriangleSpecification specification = new RightTriangleSpecification(calculator);

    @Test
    public void testIsSpecifiedShouldReturnTrueWhenTriangleIsRight() {
        //given
        Mockito.when(calculator.isRight(Mockito.any(Triangle.class))).thenReturn(true);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalseWhenTriangleIsNotRight() {
        //given
        Mockito.when(calculator.isRight(Mockito.any(Triangle.class))).thenReturn(false);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertFalse(actual);
    }
}