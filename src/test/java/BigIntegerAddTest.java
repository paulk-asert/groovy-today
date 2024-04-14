import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class BigIntegerAddTest {
    @Test
    public void testAdd() {
        assertEquals(BigInteger.valueOf(21),
            BigInteger.valueOf(12).add(BigInteger.valueOf(9)));
    }
}
