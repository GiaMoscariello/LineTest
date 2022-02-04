
import model.*;
import org.junit.Test;

public class GeometricLineTest {

    @Test
    public void implicitLineHasCorrectAngularCoeff() {
        Double expected = -2.00;
        GeometricLine actualLine = new ImplicitLine( 2.00, 1.00, 1.00);

        assert(expected.equals(actualLine.angularCoefficient()));
    }

    @Test
    public void implicitLineHasInfinityAngularCoeff() {
        Double expected = Double.POSITIVE_INFINITY;

        GeometricLine actualLine = new ImplicitLine(2.00, 0.00, 1.00);

        assert(expected.equals(actualLine.angularCoefficient()));
    }

    @Test
    public void explicitLineHasCorrectAngularCoeff() {
        Double expected = 2.00;
        GeometricLine actualLine = new ExplicitLine(2.00, 1.00);

        assert(expected.equals(actualLine.angularCoefficient()));
    }

    @Test
    public void pointsLineHasAngularCoeff() {
        Double expected =  2.00;
        GeometricLine actualLine = new PointsLine(5.00, 12.00, 2.00);

        assert(expected.equals(actualLine.angularCoefficient()));
    }

    @Test
    public void cantCalculateAngularCoeff() {
        GeometricLine actualLine = new PointsLine(5.00, 12.00, null);

        assert(actualLine.angularCoefficient().equals(Double.NaN));
    }
    
    
    @Test
    public void linesAreNotParallel() {
        GeometricLine line1 = new ExplicitLine( 2.00,  1.00);
        GeometricLine line2 = new ImplicitLine( 2.00,  1.00,  1.00);

        assert(!line1.isParallelWith(line2));
    }

    @Test
    public void linesAreParallel() {
        GeometricLine line1 = new ExplicitLine( 2.00,  1.00);
        GeometricLine line2 = new ImplicitLine( -4.00,  2.00,  1.00);

        assert(line1.isParallelWith(line2));
    }

    @Test
    public void linesArePerpendicular() {
        GeometricLine line1 = new ImplicitLine( 4.0,  3.00,  0.00);
        GeometricLine line2 = new ImplicitLine( -6.00,  8.00,  5.00);

        GeometricLine line3 = new ExplicitLine( -5.00,  12.00);
        GeometricLine line4 = new ExplicitLine(Math.pow(5, -1),  4.00);

        assert(line1.isPerpendicularWith(line2));
        assert(line4.isPerpendicularWith(line3));
    }
}
