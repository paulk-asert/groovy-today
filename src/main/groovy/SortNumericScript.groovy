var nums = ['222', 'ZERO', '4', '33', 'PI', 'TWO']
assert nums.toSorted() == ['222', '33', '4', 'PI', 'TWO', 'ZERO']
nums.sort(String::isInteger)
var pp = nums.partitionPoint{ !it.integer }
nums.sort(0..<pp, Comparator.reverseOrder())
nums.sort(pp..-1, String::toInteger)
assert nums == ['ZERO', 'TWO', 'PI', '4', '33', '222']

assert nums.collect {
    switch(it) {
        case { it.integer } -> it.toInteger()
        case ['PI', 'E'] -> Math."$it"
        default -> BigInteger."$it"
    }
} == [0, 2, 3.141592653589793, 4, 33, 222]
