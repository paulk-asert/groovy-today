package roman1

import com.github.fracpete.romannumerals4j.RomanNumeralFormat

class RomanNumeral {
    private fmt = new RomanNumeralFormat()
    private int d
    RomanNumeral(String s) { d = fmt.parse(s) }
    RomanNumeral(int d) { this.d = d }
    def plus(RomanNumeral other) { new RomanNumeral(d + other.d) }
    String toString() { fmt.format(d) }
    boolean equals(other) { d == other.d }
}

def propertyMissing(String p) {
    new RomanNumeral(p)
}

assert XII + IX == XXI
