package com.epam.task07.main.validator.triangle;

import java.util.List;

public class TriangleValidator {

    private static final double DELTA = 0.01;
    private static final int X_POINT_A_INDEX = 0;
    private static final int Y_POINT_A_INDEX = 1;
    private static final int X_POINT_B_INDEX = 2;
    private static final int Y_POINT_B_INDEX = 3;
    private static final int X_POINT_C_INDEX = 4;
    private static final int Y_POINT_C_INDEX = 5;

    public boolean arePointsCollinear(List<Double> coordinates) {
        double xPointA = coordinates.get(X_POINT_A_INDEX);
        double xPointB = coordinates.get(X_POINT_B_INDEX);
        double xPointC = coordinates.get(X_POINT_C_INDEX);

        double yPointA = coordinates.get(Y_POINT_A_INDEX);
        double yPointB = coordinates.get(Y_POINT_B_INDEX);
        double yPointC = coordinates.get(Y_POINT_C_INDEX);

        double leftSideExpression = (xPointA - xPointC) * (yPointB - yPointC);
        double rightSideExpression = (xPointB - xPointC) * (yPointA - yPointC);
        return Math.abs(leftSideExpression - rightSideExpression) < DELTA;
    }
}