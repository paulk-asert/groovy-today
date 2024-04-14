import one.AudioBook
import one.PrintedBook

beforeMethodCall { call ->
    if (call.methodAsString == 'equals') {
        lhsType = getType(call.objectExpression)
        rhsType = getType(call.arguments[0])
        if (lhsType != rhsType &&
                lhsType != classNodeFor(PrintedBook) &&
                rhsType != classNodeFor(AudioBook)) {
            addStaticTypeError("Invalid equality check: $lhsType.name != $rhsType.name", call)
            handled = true
        }
    }
}
