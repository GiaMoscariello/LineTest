package it.dove.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class PointLine implements GeometricLine {
    PointBigDecimal point;
    BigDecimal m;

    @Override
    public BigDecimal angularCoefficient() throws NumberFormatException {
        return m == null ? BigDecimal.valueOf(Double.NaN) : m;
    }
}
