package com.epam.task07.main.logic.comparator;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.observer.TriangleObservable;

import java.util.Comparator;

public class xCoordinateFirstPointComparator implements Comparator<TriangleObservable> {

    @Override
    public int compare(TriangleObservable first, TriangleObservable second) {
        Point firstPoint = first.getPointA();
        Point secondPoint = second.getPointA();

        double firstX = firstPoint.getX();
        double SecondX = secondPoint.getX();

        return Double.compare(firstX, SecondX);
    }
}