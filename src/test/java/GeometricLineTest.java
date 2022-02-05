
import model.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GeometricLineTest {

    @Test
    public void implicitLineHasCorrectAngularCoeff() {
        BigDecimal expected = BigDecimal.valueOf(-2);
        BigDecimal a = BigDecimal.valueOf(2);
        BigDecimal b = BigDecimal.valueOf(1);
        BigDecimal c = BigDecimal.valueOf(1);

        GeometricLine actualLine = new ImplicitLine(a, b, c);

        assertEquals(expected, actualLine.angularCoefficient());
    }

    @Test
    public void implicitLineWithCoefficientsZeroShouldFail() {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = BigDecimal.ZERO;
        BigDecimal c = BigDecimal.valueOf(1);

        assertThrows(NumberFormatException.class, () -> new ImplicitLine(a, b, c));
    }

    @Test
    public void implicitLineHasInfinityAngularCoeff() {
        BigDecimal a = BigDecimal.valueOf(2);
        BigDecimal b = BigDecimal.valueOf(0);
        BigDecimal c = BigDecimal.valueOf(1);

        GeometricLine actualLine = new ImplicitLine(a, b, c);

        assertThrows(NumberFormatException.class, actualLine::angularCoefficient);
    }

    @Test
    public void explicitLineHasCorrectAngularCoeff() {
        BigDecimal expected = BigDecimal.valueOf(2);
        BigDecimal m = BigDecimal.valueOf(2);
        BigDecimal q = BigDecimal.valueOf(1);

        GeometricLine actualLine = new ExplicitLine(m, q);

        assertEquals(expected, actualLine.angularCoefficient());
    }

    @Test
    public void pointsLineHasAngularCoeff() {
        BigDecimal expected = BigDecimal.valueOf(2);
        BigDecimal x = BigDecimal.valueOf(5);
        BigDecimal y = BigDecimal.valueOf(12);
        BigDecimal m = BigDecimal.valueOf(2);

        GeometricLine actualLine = new PointLine(x, y, m);

        assertEquals(expected, actualLine.angularCoefficient());
    }

    @Test
    public void cantCalculateAngularCoeff() {
        BigDecimal x = BigDecimal.valueOf(5);
        BigDecimal y = BigDecimal.valueOf(12);

        GeometricLine actualLine = new PointLine(x, y, null);

        assertThrows(NumberFormatException.class, actualLine::angularCoefficient);
    }


    @Test
    public void linesAreNotParallel() {
        BigDecimal a = BigDecimal.valueOf(2);
        BigDecimal b = BigDecimal.valueOf(1);
        BigDecimal c = BigDecimal.valueOf(1);

        BigDecimal m = BigDecimal.valueOf(2);
        BigDecimal q = BigDecimal.valueOf(1);

        GeometricLine line1 = new ExplicitLine(m, q);
        GeometricLine line2 = new ImplicitLine(a, b, c);

        assertFalse(line1.isParallelWith(line2));
    }

    @Test
    public void linesAreParallel() {
        BigDecimal a = BigDecimal.valueOf(-4);
        BigDecimal b = BigDecimal.valueOf(2);
        BigDecimal c = BigDecimal.valueOf(1);

        BigDecimal m = BigDecimal.valueOf(2);
        BigDecimal q = BigDecimal.valueOf(1);

        GeometricLine line1 = new ExplicitLine(m, q);
        GeometricLine line2 = new ImplicitLine(a, b, c);

        assertTrue(line1.isParallelWith(line2));
    }

    @Test
    public void linesArePerpendicular() {
        BigDecimal a1 = BigDecimal.valueOf(4);
        BigDecimal b1 = BigDecimal.valueOf(3);
        BigDecimal c1 = BigDecimal.valueOf(0);

        BigDecimal a2 = BigDecimal.valueOf(-6);
        BigDecimal b2 = BigDecimal.valueOf(8);
        BigDecimal c2 = BigDecimal.valueOf(5);


        BigDecimal m1 = BigDecimal.valueOf(-5.0);
        BigDecimal q1 = BigDecimal.valueOf(12);

        BigDecimal m2 = BigDecimal.valueOf(Math.pow(5, -1));
        BigDecimal q2 = BigDecimal.valueOf(4);

        GeometricLine line1 = new ImplicitLine(a1, b1, c1);
        GeometricLine line2 = new ImplicitLine(a2, b2, c2);

        GeometricLine line3 = new ExplicitLine(m1, q1);
        GeometricLine line4 = new ExplicitLine(m2, q2);

        assertTrue(line1.isPerpendicularWith(line2));
        assertTrue(line3.isPerpendicularWith(line4));
    }
}
