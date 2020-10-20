package com.epam.task07.main.model;

import java.util.Objects;

public class TriangleSides {

    private static final double DELTA = 0.01;

    private final double sideAB;
    private final double sideBC;
    private final double sideCA;

    public TriangleSides(final double sideAB, final double sideBC, final double sideCA) {
        this.sideAB = sideAB;
        this.sideBC = sideBC;
        this.sideCA = sideCA;
    }

    public double getSideAB() {
        return sideAB;
    }

    public double getSideBC() {
        return sideBC;
    }

    public double getSideCA() {
        return sideCA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleSides that = (TriangleSides) o;
        return Math.abs(that.sideAB - sideAB) < DELTA &&
                Math.abs(that.sideBC - sideBC) < DELTA &&
                Math.abs(that.sideCA - sideCA) < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideAB, sideBC, sideCA);
    }

    @Override
    public String toString() {
        return String.format("TriangleSides{sideAB=%f, sideBC=%f, sideCA=%f}",
                sideAB, sideBC, sideCA);
    }
}