package it.dove.model;

import java.math.BigDecimal;

public interface GeometricLine {
    BigDecimal angularCoefficient() throws NumberFormatException;

    default boolean isParallelWith(GeometricLine line) {
        return line.angularCoefficient().stripTrailingZeros()
                .equals(angularCoefficient().stripTrailingZeros());
    }

    default boolean isPerpendicularWith(GeometricLine line) {
        return this.angularCoefficient().multiply(line.angularCoefficient()).intValue() == -1;
    }
}