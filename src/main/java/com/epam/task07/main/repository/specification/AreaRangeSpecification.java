package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.observer.TriangleObservable;
import com.epam.task07.main.repository.TriangleSpecification;

public class AreaRangeSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator;
    private final double minArea;
    private final double maxArea;

    public AreaRangeSpecification(final double minArea, final double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = new TriangleCalculator();
    }

    /*private package (for testing)*/ AreaRangeSpecification(TriangleCalculator calculator, final double minArea, final double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(TriangleObservable triangle) {
        double area = calculator.calculateArea(triangle);
        return Double.compare(area, minArea) > 0 && Double.compare(area, maxArea) < 0;
    }
}