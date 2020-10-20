package com.epam.task07.main.data;

import com.epam.task07.main.validator.triangle.TriangleValidator;
import com.epam.task07.main.model.Point;
import com.epam.task07.main.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TriangleCreator {

    private static final Logger LOGGER = LogManager.getLogger(TriangleCreator.class);

    private static final int X_POINT_A_INDEX = 0;
    private static final int Y_POINT_A_INDEX = 1;
    private static final int X_POINT_B_INDEX = 2;
    private static final int Y_POINT_B_INDEX = 3;
    private static final int X_POINT_C_INDEX = 4;
    private static final int Y_POINT_C_INDEX = 5;

    private final TriangleValidator triangleValidator;

    public TriangleCreator(final TriangleValidator triangleValidator) {
        this.triangleValidator = triangleValidator;
    }

    public Optional<Triangle> create(List<Double> pointCoordinates)  {
        if (triangleValidator.arePointsCollinear(pointCoordinates)) {
            LOGGER.warn("Incorrect point coordinates for creating a triangle: " + pointCoordinates.toString());
            return Optional.empty();
        }
        double xPointA = pointCoordinates.get(X_POINT_A_INDEX);
        double yPointA = pointCoordinates.get(Y_POINT_A_INDEX);
        Point pointA = new Point(xPointA, yPointA);
        double xPointB = pointCoordinates.get(X_POINT_B_INDEX);
        double yPointB = pointCoordinates.get(Y_POINT_B_INDEX);
        Point pointB = new Point(xPointB, yPointB);
        double xPointC = pointCoordinates.get(X_POINT_C_INDEX);
        double yPointC = pointCoordinates.get(Y_POINT_C_INDEX);
        Point pointC = new Point(xPointC, yPointC);
        return Optional.of(new Triangle(pointA, pointB, pointC));
    }
}