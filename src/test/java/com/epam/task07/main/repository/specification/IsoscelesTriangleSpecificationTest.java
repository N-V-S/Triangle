package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IsoscelesTriangleSpecificationTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
    private final IsoscelesTriangleSpecification specification = new IsoscelesTriangleSpecification(calculator);

    @Test
    public void testIsSpecifiedShouldReturnTrueWhenTriangleIsIsosceles() {
        //given
        Mockito.when(calculator.isIsosceles(Mockito.any(Triangle.class))).thenReturn(true);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalseWhenTriangleIsNotIsosceles() {
        //given
        Mockito.when(calculator.isIsosceles(Mockito.any(Triangle.class))).thenReturn(false);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertFalse(actual);
    }
}