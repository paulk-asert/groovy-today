import groovy.transform.TypeChecked
import roman1.RomanNumeral

@TypeChecked(extensions = 'ValidRoman.groovy')
def method() {
assert MMMCMXCIX + I == MMMM
}

def propertyMissing(String p) {
    new RomanNumeral(p)
}

method()
