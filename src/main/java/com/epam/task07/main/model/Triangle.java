package com.epam.task07.main.model;

import java.util.Objects;

public class Triangle {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(final Point pointA, final Point pointB, final Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return pointA.equals(triangle.pointA) &&
                pointB.equals(triangle.pointB) &&
                pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return String.format("Triangle{id=%d, pointA=%s, pointB=%s, pointC=%s}",
                pointA.toString(), pointB.toString(), pointC.toString());
    }
}