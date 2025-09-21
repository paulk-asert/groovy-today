import org.apache.groovy.typecheckers.CheckingVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression

beforeVisitMethod  { MethodNode method ->
    def visitor = new CheckingVisitor() {
        @Override
        void visitMethodCallExpression(MethodCallExpression call) {
            if (call.methodAsString != 'valueOf') return
            if (call?.arguments?.size() != 1) return
            var arg = call.arguments[0]
            try {
                if (arg instanceof ConstantExpression) {
                    Integer.valueOf(arg.value)
                }
            } catch (NumberFormatException ex) {
                addStaticTypeError("Not a valid Integer: ${arg.value}", arg)
            }
        }
    }
    method.code.visit(visitor)
}
