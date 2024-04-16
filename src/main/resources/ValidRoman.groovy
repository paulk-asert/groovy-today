import org.codehaus.groovy.ast.expr.VariableExpression
import roman1.RomanNumeral

import java.text.ParseException

unresolvedVariable  { VariableExpression ve ->
    try {
        new RomanNumeral(ve.name)
        storeType(ve, classNodeFor(RomanNumeral))
    } catch(ParseException unused) {
        addStaticTypeError("Not a valid roman numeral: $ve.name", ve)
    }
    handled = true
}
