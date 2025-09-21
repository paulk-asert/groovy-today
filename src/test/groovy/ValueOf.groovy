import groovy.transform.TypeChecked

@TypeChecked(extensions = 'ConstantIntegerChecker.groovy')
def main() {
//    int version = Integer.valueOf('5')
    int version = Integer.valueOf('five')
    println "Hello from Groovy $version!"
}
