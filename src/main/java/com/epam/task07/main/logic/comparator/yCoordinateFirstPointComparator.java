package com.epam.task07.main.logic.comparator;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.observer.TriangleObservable;

import java.util.Comparator;

public class yCoordinateFirstPointComparator implements Comparator<TriangleObservable> {

    @Override
    public int compare(TriangleObservable first, TriangleObservable second) {
        Point firstPoint = first.getPointA();
        Point secondPoint = second.getPointA();

        double firstY = firstPoint.getY();
        double SecondY = secondPoint.getY();

        return Double.compare(firstY, SecondY);
    }
}