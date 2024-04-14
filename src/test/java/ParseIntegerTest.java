import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseIntegerTest {
    @Test
    public void testWeCanAddTwoIntegers() {
        assertEquals(Integer.parseInt("21"),
            Integer.parseInt("12") + Integer.parseInt("9"));
    }
}
