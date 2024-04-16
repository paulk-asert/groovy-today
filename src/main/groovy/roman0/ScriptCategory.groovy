package roman0

import com.github.fracpete.romannumerals4j.RomanNumeralFormat

class RomanCategory {
    private static fmt = new RomanNumeralFormat()
    static Integer toDecimal(String self) {
        fmt.parse(self)
    }
    static String toRoman(Integer self) {
        fmt.format(self)
    }
}

use(RomanCategory) {
    assert 'XII'.toDecimal() == 12
    assert 9.toRoman() == 'IX'
    assert 'XII'.toDecimal() + 'IX'.toDecimal() == 'XXI'.toDecimal()
}
