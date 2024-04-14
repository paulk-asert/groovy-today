import org.apache.commons.math3.linear.MatrixUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixAddTest {
    @Test
    public void testAdd() {
        double[][] d1 = { {10d, 0d}, {0d, 10d} };
        var m1 = MatrixUtils.createRealMatrix(d1);
        double[][] d2 = { {-1d, 1d}, {1d, -1d} };
        var m2 = MatrixUtils.createRealMatrix(d2);
        double[][] d3 = { {20d, -20d}, {-20d, 20d} };
        var m3 = MatrixUtils.createRealMatrix(d3);
        assertEquals(m3, m1.multiply(m2.power(2)));
    }
}
