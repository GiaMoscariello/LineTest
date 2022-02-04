package model;


import lombok.Value;

@Value
public class PointLine implements GeometricLine {
    Double x;
    Double y;
    Double m;

    @Override
    public Double angularCoefficient() {
        return m == null ? Double.NaN : m;
    }
}
