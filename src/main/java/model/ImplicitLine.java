package model;

import lombok.Value;

@Value
public class ImplicitLine implements GeometricLine {
    Double a;
    Double b;
    Double c;

    @Override
    public Double angularCoefficient() {
        if (Double.valueOf(0).equals(b))
            return Double.POSITIVE_INFINITY;
        else return (a / b) * (-1.00);
    }
}
