package com.epam.task07.main.observer;

import com.epam.task07.main.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Set;

import static org.mockito.Mockito.verify;

public class TriangleObservableTest {

    private static final int ID_TRIANGLE = 1;
    private static final Point POINT_A = new Point(-3, 0);
    private static final Point POINT_B = new Point(0, 2);
    private static final Point POINT_C = new Point(3, 0);
    private static final Point NEW_POINT_A = new Point(-3, 0);

    private final TriangleObserver observer = Mockito.mock(TriangleObserver.class);

    @Test
    public void testAddObserverShouldAddObserverToSetWhenGetObserver() {
        //given
        TriangleObservable triangle = new TriangleObservable(ID_TRIANGLE, POINT_A, POINT_B, POINT_C);
        Set<Observer> expected = Collections.singleton(observer);
        //when
        triangle.addObserver(observer);
        //then
        Set<Observer> actual = triangle.getObservers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveObserverShouldRemoveObserverFromSetWhenGetObserver() {
        //given
        TriangleObservable triangle = new TriangleObservable(ID_TRIANGLE, POINT_A, POINT_B, POINT_C);
        triangle.addObserver(observer);
        Set<Observer> expected = Collections.emptySet();
        //when
        triangle.removeObserver(observer);
        //then
        Set<Observer> actual = triangle.getObservers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetPointAShouldNotifyObserversWhenGetNewPointA() {
        //given
        TriangleObservable triangle = new TriangleObservable(ID_TRIANGLE, POINT_A, POINT_B, POINT_C);
        triangle.addObserver(observer);
        //when
        triangle.setPointA(NEW_POINT_A);
        //then
        verify(observer).updateParameters(triangle);
    }
}