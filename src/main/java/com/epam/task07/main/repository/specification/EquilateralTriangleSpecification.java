package com.epam.task07.main.repository.specification;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.observer.TriangleObservable;
import com.epam.task07.main.repository.TriangleSpecification;

public class EquilateralTriangleSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator;

    /*private package (for testing)*/ EquilateralTriangleSpecification(TriangleCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public boolean specified(TriangleObservable triangle) {
        return calculator.isEquilateral(triangle);
    }
}
