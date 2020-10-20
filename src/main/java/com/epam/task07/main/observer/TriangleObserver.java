package com.epam.task07.main.observer;

import com.epam.task07.main.logic.TriangleCalculator;
import com.epam.task07.main.model.TriangleAngles;
import com.epam.task07.main.model.TriangleParameters;
import com.epam.task07.main.model.TriangleSides;

import java.util.HashMap;
import java.util.Map;

public class TriangleObserver implements Observer {

    private static final TriangleObserver TRIANGLE_OBSERVER = new TriangleObserver();

    private Map<Integer, TriangleParameters> parameters = new HashMap<Integer, TriangleParameters>();
    private final TriangleCalculator calculator = new TriangleCalculator();

    private TriangleObserver() {
    }

    public static TriangleObserver getTriangleObserver() {
        return TRIANGLE_OBSERVER;
    }

    public Map<Integer, TriangleParameters> getParameters() {
        return parameters;
    }

    @Override
    public void updateParameters(TriangleObservable triangle) {
        TriangleSides sides = calculator.getAllSide(triangle);
        TriangleAngles angles = calculator.getAllDegreesAngles(triangle);
        double perimeter = calculator.calculatePerimeter(triangle);
        double area = calculator.calculateArea(triangle);

        TriangleParameters triangleParameters = new TriangleParameters(sides, angles, perimeter, area);
        int id = triangle.getId();
        parameters.put(id, triangleParameters);
    }
}
