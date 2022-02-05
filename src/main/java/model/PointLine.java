package model;


import lombok.Value;

import java.math.BigDecimal;

@Value
public class PointLine implements GeometricLine {
    BigDecimal x;
    BigDecimal y;
    BigDecimal m;

    @Override
    public BigDecimal angularCoefficient() throws NumberFormatException {
        return m == null ? BigDecimal.valueOf(Double.NaN) : m;
    }
}
