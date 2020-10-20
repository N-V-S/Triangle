package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.observer.TriangleObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ObtuseTriangleSpecificationTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
    private final ObtuseTriangleSpecification specification = new ObtuseTriangleSpecification(calculator);

    @Test
    public void testIsSpecifiedShouldReturnTrueWhenTriangleIsObtuse() {
        //given
        Mockito.when(calculator.isObtuse(Mockito.any(Triangle.class))).thenReturn(true);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalseWhenTriangleIsNotObtuse() {
        //given
        Mockito.when(calculator.isObtuse(Mockito.any(Triangle.class))).thenReturn(false);
        //when
        boolean actual = specification.specified(Mockito.any(TriangleObservable.class));
        //then
        Assert.assertFalse(actual);
    }
}