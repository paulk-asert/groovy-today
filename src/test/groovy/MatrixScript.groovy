import groovy.transform.OperatorRename
import org.apache.commons.math3.linear.MatrixUtils

double[][] d1 = [ [10d, 0d], [0d, 10d] ]
var m1 = MatrixUtils.createRealMatrix(d1)
double[][] d2 = [ [-1d, 1d], [1d, -1d] ]
var m2 = MatrixUtils.createRealMatrix(d2)
double[][] d3 = [ [20d, -20d], [-20d, 20d] ]
var m3 = MatrixUtils.createRealMatrix(d3)
assert m3 == m1 * m2 ** 2

@OperatorRename(plus='add', multiply='scalarMultiply')
def testUnitMatrixAddition() {
    double[][] d = [ [1d, 0d], [0d, 1d] ]
    var m = MatrixUtils.createRealMatrix(d)
    assert m.add(m) == m.scalarMultiply(2) // methods unchanged
    assert m + m == m * 2          // additional operator mappings
}

testUnitMatrixAddition()
