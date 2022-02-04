package model;

import lombok.Value;

@Value
public class ExplicitLine implements GeometricLine {
    Double m;
    Double q;

    @Override
    public Double angularCoefficient() {
        return m;
    }
}
