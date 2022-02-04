package model;

public interface GeometricLine {
    Double angularCoefficient();

    default boolean isParallelWith(GeometricLine line) {
        return line.angularCoefficient().equals(angularCoefficient());
    }

    default boolean isPerpendicularWith(GeometricLine line) {
        return (line.angularCoefficient() * angularCoefficient()) == (-1.00);
    }
}