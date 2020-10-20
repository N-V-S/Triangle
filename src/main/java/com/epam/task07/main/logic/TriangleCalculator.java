package com.epam.task07.main.logic;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.model.Triangle;
import com.epam.task07.main.model.TriangleAngles;
import com.epam.task07.main.model.TriangleSides;

public class TriangleCalculator {

    private static final double RIGHT_DEGREE_ANGLE = 90;
    private static final double DELTA = 0.01;

    public boolean isIsosceles(Triangle triangle) {
        TriangleSides sides = getAllSide(triangle);
        double sideAB = sides.getSideAB();
        double sideВС = sides.getSideBC();
        double sideСA = sides.getSideCA();

        return Math.abs(sideAB - sideВС) < DELTA ||
                Math.abs(sideВС - sideСA) < DELTA ||
                Math.abs(sideAB - sideСA) < DELTA;
    }

    public boolean isEquilateral(Triangle triangle) {
        TriangleSides sides = getAllSide(triangle);
        double sideAB = sides.getSideAB();
        double sideВС = sides.getSideBC();
        double sideСA = sides.getSideCA();

        return Math.abs(sideAB - sideВС) < DELTA &&
                Math.abs(sideВС - sideСA) < DELTA;
    }

    public TriangleSides getAllSide(Triangle triangle) {
        Point pointA = triangle.getPointA();
        Point pointB = triangle.getPointB();
        Point pointC = triangle.getPointC();

        double sideAB = getSide(pointA, pointB);
        double sideВС = getSide(pointB, pointC);
        double sideСA = getSide(pointC, pointA);

        return new TriangleSides(sideAB, sideВС, sideСA);
    }

    private double getSide(Point pointOne, Point pointTwo) {
        double deltaX = pointTwo.getX() - pointOne.getX();
        double deltaY = pointTwo.getY() - pointOne.getY();
        return Math.hypot(deltaX, deltaY);
    }

    public boolean isRight(Triangle triangle) {
        double maxAngle = getMaxDegreeAngle(triangle);
        return Math.abs(maxAngle - RIGHT_DEGREE_ANGLE) < DELTA;
    }

    public boolean isAcute(Triangle triangle) {
        double maxAngle = getMaxDegreeAngle(triangle);
        return maxAngle < RIGHT_DEGREE_ANGLE - DELTA;
    }

    public boolean isObtuse(Triangle triangle) {
        double maxAngle = getMaxDegreeAngle(triangle);
        return maxAngle > RIGHT_DEGREE_ANGLE + DELTA;
    }

    private double getMaxDegreeAngle(Triangle triangle) {
        TriangleAngles angles = getAllDegreesAngles(triangle);
        double angleA = angles.getAngleA();
        double angleВ = angles.getAngleB();
        double angleС = angles.getAngleC();

        double maxAngleAorB = Math.max(angleA, angleВ);
        return Math.max(maxAngleAorB, angleС);
    }

    public TriangleAngles getAllDegreesAngles(Triangle triangle) {
        TriangleSides sides = getAllSide(triangle);
        double sideAB = sides.getSideAB();
        double sideВС = sides.getSideBC();
        double sideСA = sides.getSideCA();

        double angleA = getDegreesAngle(sideAB, sideСA, sideВС);
        double angleВ = getDegreesAngle(sideВС, sideAB, sideСA);
        double angleС = getDegreesAngle(sideСA, sideВС, sideAB);

        return new TriangleAngles(angleA, angleВ, angleС);
    }

    private double getDegreesAngle(double firstAdjacentSide, double secondAdjacentSide, double oppositeSide) {
        double firstAdjacentSideSquare = Math.pow(firstAdjacentSide, 2);
        double secondAdjacentSideSquare = Math.pow(secondAdjacentSide, 2);
        double oppositeSideSquare = Math.pow(oppositeSide, 2);

        double radianAngle = Math.acos((secondAdjacentSideSquare + oppositeSideSquare - firstAdjacentSideSquare)/(2 * secondAdjacentSide * oppositeSide));
        return Math.toDegrees(radianAngle);
    }

    public double calculateArea(Triangle triangle) {
        Point pointA = triangle.getPointA();
        Point pointB = triangle.getPointB();
        Point pointC = triangle.getPointC();

        double xPointA = pointA.getX();
        double yPointA = pointA.getY();
        double xPointB = pointB.getX();
        double yPointB = pointB.getY();
        double xPointC = pointC.getX();
        double yPointC = pointC.getY();

        return Math.abs((xPointA - xPointC)*(yPointB - yPointC)-(xPointB - xPointC)*(yPointA - yPointC))/2;
    }

    public double calculatePerimeter(Triangle triangle) {
        TriangleSides sides = getAllSide(triangle);
        double sideAB = sides.getSideAB();
        double sideВС = sides.getSideBC();
        double sideСA = sides.getSideCA();

        return sideAB + sideВС + sideСA;
    }
}