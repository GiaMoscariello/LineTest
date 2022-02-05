package it.dove.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class PointBigDecimal {
    BigDecimal x;
    BigDecimal y;

    public PointBigDecimal(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }
}
