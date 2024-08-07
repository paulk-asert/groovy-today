package roman3

import com.github.fracpete.romannumerals4j.RomanNumeralFormat
import groovy.transform.Canonical
import groovy.transform.Sortable

@Sortable @Canonical
class RomanNumeral {
    private fmt = new RomanNumeralFormat()
    final int d
    RomanNumeral(String s) { d = fmt.parse(s.toUpperCase()) }
    RomanNumeral(int d) { this.d = d }
    def plus(RomanNumeral other) { new RomanNumeral(d + other.d) }
    def multiply(RomanNumeral other) { new RomanNumeral(d * other.d) }
    def power(RomanNumeral other) { new RomanNumeral(d ** other.d) }
    String toString() { fmt.format(d) }
    RomanNumeral next() { new RomanNumeral(d+1) }
}

def propertyMissing(String p) {
    new RomanNumeral(p)
}

assert XII + IX == XXI

assert [X, IX, IV, V, VI].sort() == [iv, v, vi, ix, x]

assert [LVII + LVII, V * III, V ** II, IV..(V+I), [X, V, I].sort()]
    == [       cxiv,      xv,     xxv,    iv..vi, [i, v, x]       ]
