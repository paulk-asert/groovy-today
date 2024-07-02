import com.github.fracpete.romannumerals4j.RomanNumeralFormat;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;

public class RomanTest {
    @Test
    public void testRomanNumerals() throws ParseException {
        var fmt = new RomanNumeralFormat();
        assertEquals(fmt.parse("XII"), 12);
        assertEquals(fmt.format(9), "IX");
        assertEquals(fmt.format(fmt.parse("XII").intValue() + fmt.parse("IX").intValue()), "XXI");
    }
}
