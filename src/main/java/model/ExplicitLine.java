package model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class ExplicitLine extends GeometricLine {
    Double m, q;

    @Override
    public Double angularCoefficient() {
        return m;
    }
}
