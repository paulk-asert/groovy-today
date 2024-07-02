import groovy.transform.*
import groovy.transform.options.ImmutablePropertyHandler
import groovyjarjarantlr4.v4.runtime.misc.Tuple2

@PropertyOptions(propertyHandler = ImmutablePropertyHandler)
record Point(List<Tuple2<Integer, Integer>> points, String color) {
    @Memoized
    String description() {
        "${color.toUpperCase()} shape with points: ${points.join(', ')}"
    }
}

var points = [[0,0], [10,0], [10,10], [10,0]]
println new Point(points, 'red').description()
