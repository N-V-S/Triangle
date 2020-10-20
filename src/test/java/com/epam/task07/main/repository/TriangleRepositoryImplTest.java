package com.epam.task07.main.repository;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.observer.TriangleObservable;
import com.epam.task07.main.repository.specification.AcuteTriangleSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TriangleRepositoryImplTest {

    private static final int ID_ACUTE_TRIANGLE = 1;
    private static final TriangleObservable ACUTE_TRIANGLE = new TriangleObservable(ID_ACUTE_TRIANGLE, new Point(0, 0), new Point(0.5, 0.866), new Point(1, 0));

    @Test
    public void testAddShouldAddTriangleToRepositoryWhenGetTriangle() {
        //given
        TriangleRepositoryImpl repository = new TriangleRepositoryImpl();
        int startSize = repository.size();
        //when
        repository.add(ACUTE_TRIANGLE);
        //then
        int endSize = repository.size();
        Assert.assertTrue(startSize < endSize);
    }

    @Test
    public void testRemoveShouldRemoveTriangleFromRepositoryWhenTriangleIsInTheList() {
        //given
        TriangleRepositoryImpl repository = new TriangleRepositoryImpl();
        repository.add(ACUTE_TRIANGLE);
        int startSize = repository.size();
        //when
        repository.remote(ACUTE_TRIANGLE);
        //then
        int endSize = repository.size();
        Assert.assertTrue(startSize > endSize);
    }

    @Test
    public void testQueryShouldReturnSpecifiedTrianglesMapWhenGetSpecification() {
        //given
        TriangleRepositoryImpl repository = new TriangleRepositoryImpl();
        AcuteTriangleSpecification specification = Mockito.mock(AcuteTriangleSpecification.class);
        when(specification.specified(any(TriangleObservable.class))).thenReturn(true);
        repository.add(ACUTE_TRIANGLE);
        Map<Integer, TriangleObservable> expected = Collections.singletonMap(ID_ACUTE_TRIANGLE, ACUTE_TRIANGLE);
        //when
        Map<Integer, TriangleObservable> actual = repository.query(specification);
        //then
        Assert.assertEquals(expected, actual);
    }
}