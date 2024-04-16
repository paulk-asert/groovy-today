package roman0

import com.github.fracpete.romannumerals4j.RomanNumeralFormat

var fmt = new RomanNumeralFormat()
String.metaClass.toDecimal {
    fmt.parse(delegate)
}
Integer.metaClass.toRoman {
    fmt.format(delegate)
}

assert 'XII'.toDecimal() == 12
assert 9.toRoman() == 'IX'
assert 'XII'.toDecimal() + 'IX'.toDecimal() == 'XXI'.toDecimal()
