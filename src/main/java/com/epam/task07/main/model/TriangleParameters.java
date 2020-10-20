package com.epam.task07.main.model;

import java.util.Objects;

public final class TriangleParameters {

    private final TriangleSides sides;
    private final TriangleAngles angles;
    private final double perimeter;
    private final double area;

    public TriangleParameters(final TriangleSides sides, final TriangleAngles angles, final double perimeter, final double area) {
        this.sides = sides;
        this.angles = angles;
        this.perimeter = perimeter;
        this.area = area;
    }

    public TriangleSides getSides() {
        return sides;
    }

    public TriangleAngles getAngles() {
        return angles;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleParameters that = (TriangleParameters) o;
        return Double.compare(that.perimeter, perimeter) == 0 &&
                Double.compare(that.area, area) == 0 &&
                sides.equals(that.sides) &&
                angles.equals(that.angles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides, angles, perimeter, area);
    }

    @Override
    public String toString() {
        return String.format("TriangleParameters{sides=%s, sides=%s, perimeter=%f, area=%f}",
                sides.toString(), angles.toString(), perimeter, area);
    }
}
