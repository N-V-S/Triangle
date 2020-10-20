package com.epam.task07.main.data;

import com.epam.task07.main.validator.triangle.TriangleValidator;
import com.epam.task07.main.model.Point;
import com.epam.task07.main.model.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

public class TriangleCreatorTest {

    private final static List<Double> CORRECT_POINT_COORDINATES = Arrays.asList(-3.0, 0.0, 0.0, 2.0, 3.0, 0.0);
    private final static List<Double> INCORRECT_POINT_COORDINATES = Arrays.asList(0.0, -1.0, 1.0, -1.0, 4.0, -1.0);

    private final TriangleValidator validator = Mockito.mock(TriangleValidator.class);

    @Test
    public void testCreateShouldReturnOptionalTriangleWhenPointCoordinatesAreValid(){
        //given
        when(validator.arePointsCollinear(anyList())).thenReturn(false);
        TriangleCreator creator = new TriangleCreator(validator);
        Optional<Triangle> expected = Optional.of(new Triangle(new Point(-3, 0), new Point(0, 2), new Point(3, 0)));
        //when
        Optional<Triangle> actual = creator.create(CORRECT_POINT_COORDINATES);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateShouldReturnOptionalEmptyWhenPointCoordinatesInvalid(){
        //given
        when(validator.arePointsCollinear(anyList())).thenReturn(true);
        TriangleCreator creator = new TriangleCreator(validator);
        Optional<Triangle> expected = Optional.empty();
        //when
        Optional<Triangle> actual = creator.create(INCORRECT_POINT_COORDINATES);
        //then
        Assert.assertEquals(expected, actual);
    }
}