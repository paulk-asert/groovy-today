package point3g

import groovy.transform.*

@RecordBase
@ToString
@EqualsAndHashCode
@RecordOptions
@TupleConstructor
@PropertyOptions
@KnownImmutable
class Point {
    int x
    int y
}
