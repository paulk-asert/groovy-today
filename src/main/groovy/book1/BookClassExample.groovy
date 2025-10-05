package book1

import groovy.transform.*

@Immutable(copyWith = true)
@Sortable(excludes = 'authors')
@AutoExternalize
class Book {
    @IndexedProperty
    List<String> authors

    String title

    Date publicationDate
}
