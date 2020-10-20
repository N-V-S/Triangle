package com.epam.task07.main.model;

import java.util.Objects;

public class TriangleAngles {

    private static final double DELTA = 0.01;

    private final double angleA;
    private final double angleB;
    private final double angleC;

    public TriangleAngles(final double angleA, final double angleB, final double angleC) {
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleAngles that = (TriangleAngles) o;
        return Math.abs(that.angleA - angleA) < DELTA &&
                Math.abs(that.angleB - angleB) < DELTA &&
                Math.abs(that.angleC - angleC) < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(angleA, angleB, angleC);
    }

    @Override
    public String toString() {
        return String.format("TriangleAngles{angleA=%f, angleB=%f, angleC=%f}",
                angleA, angleB, angleC);
    }
}