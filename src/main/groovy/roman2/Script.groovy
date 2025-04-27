package roman2

import com.github.fracpete.romannumerals4j.RomanNumeralFormat

class RomanNumeral implements Comparable {
    private fmt = new RomanNumeralFormat()
    private int d
    RomanNumeral(String s) { d = fmt.parse(s) }
    RomanNumeral(int d) { this.d = d }
    def plus(RomanNumeral other) { new RomanNumeral(d + other.d) }
    def multiply(RomanNumeral other) { new RomanNumeral(d * other.d) }
    String toString() { fmt.format(d) }
    int compareTo(other) { d <=> other.d }
    boolean equals(other) { d == other.d }
    RomanNumeral next() { new RomanNumeral(d+1) }
}

def propertyMissing(String p) {
    if (p == 'out') return System.out
    new RomanNumeral(p)
}

assert XII + IX == XXI

assert [LVII + LVII, V * III, IV..(V+I)]
    == [       CXIV,      XV,    IV..VI]

assert switch(L) {
    case L -> '50 exactly'
    case XLV..<L -> 'just below 50'
    case ~/LI{1,3}/ -> 'just above 50'
    default -> 'not close to 50'
} == '50 exactly'
