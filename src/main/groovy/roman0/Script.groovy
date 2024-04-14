package roman0

import com.github.fracpete.romannumerals4j.RomanNumeralFormat

var fmt = new RomanNumeralFormat()
assert fmt.parse('XII') == 12
assert fmt.format(9) == 'IX'
assert fmt.format(fmt.parse('XII') + fmt.parse('IX')) == 'XXI'
