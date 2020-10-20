package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.observer.TriangleObservable;
import com.epam.task07.main.repository.TriangleSpecification;

public class IsoscelesTriangleSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator;

    /*private package (for testing)*/ IsoscelesTriangleSpecification(TriangleCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public boolean specified(TriangleObservable triangle) {
        return calculator.isIsosceles(triangle);
    }
}
