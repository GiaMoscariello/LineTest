package model;

public abstract class GeometricLine {
    public abstract Double angularCoefficient();

    public boolean isParallelWith(GeometricLine line ) {
        return line.angularCoefficient().equals(angularCoefficient());
    }

    public boolean isPerpendicularWith(GeometricLine line ) {
        return  (line.angularCoefficient() * angularCoefficient()) == ((double) - 1);
    }
}