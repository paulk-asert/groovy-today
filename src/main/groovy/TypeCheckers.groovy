import groovy.transform.TypeChecked

@TypeChecked//(extensions='groovy.typecheckers.FormatStringChecker')
def method() {
//    assert String.format('%d %02X %D', 15 >> 1, 15, (int)(Math.PI**2)) == '7 0F 9'
    assert String.format('%d %02X %d', 15 >> 1, 15, (int)(Math.PI**2)) == '7 0F 9'
}

method()
