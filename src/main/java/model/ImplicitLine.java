package model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class ImplicitLine extends GeometricLine {
    Double a, b, c;

    @Override
    public Double angularCoefficient() {
        if (Double.valueOf(0).equals(b))
            return Double.POSITIVE_INFINITY;
        else return (a / b) * ((double) -1);
    }
}
