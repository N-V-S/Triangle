package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.observer.TriangleObservable;
import com.epam.task07.main.repository.TriangleSpecification;

public class PerimeterRangeSpecification implements TriangleSpecification {

    private final double minPerimeter;
    private final double maxPerimeter;
    private final TriangleCalculator calculator;

    public PerimeterRangeSpecification(final double minPerimeter, final double maxArea) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxArea;
        calculator = new TriangleCalculator();
    }

    /*private package (for testing)*/ PerimeterRangeSpecification(TriangleCalculator calculator, final double minPerimeter, final double maxArea) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxArea;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(TriangleObservable triangle) {
        double perimeter = calculator.calculatePerimeter(triangle);
        return Double.compare(perimeter, minPerimeter) > 0 && Double.compare(perimeter, maxPerimeter) < 0;
    }
}