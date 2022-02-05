package it.dove.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ExplicitLine implements GeometricLine {
    BigDecimal m;
    BigDecimal q;

    @Override
    public BigDecimal angularCoefficient() throws NumberFormatException {
        return m.stripTrailingZeros();
    }
}
