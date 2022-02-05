package it.dove.model;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Value
public class ImplicitLine implements GeometricLine {
    BigDecimal a;
    BigDecimal b;
    BigDecimal c;

    public ImplicitLine(BigDecimal a, BigDecimal b, BigDecimal c) {
        if (BigDecimal.ZERO.equals(a) && BigDecimal.ZERO.equals(b))
            throw new NumberFormatException("Coefficients a and b are both zero");
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    public BigDecimal angularCoefficient() throws NumberFormatException {
        if (BigDecimal.ZERO.equals(b))
            return BigDecimal.valueOf(Double.POSITIVE_INFINITY);
        else return (a.divide(b, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(-1)).stripTrailingZeros();
    }
}
