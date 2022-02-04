package model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class PointsLine extends GeometricLine {
    Double x, y, m;

    @Override
    public Double angularCoefficient() {
        return m == null ? Double.NaN : m;
    }
}
