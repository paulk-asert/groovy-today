import groovy.transform.*
import groovy.transform.builder.*
import groovy.transform.options.*

@Sortable(includes = ['title', 'author'])
@ToString(includeNames = true)
@PropertyOptions(propertyHandler = ImmutablePropertyHandler)
record Book(String title, String author,
            int yearPublished, Set<String> genres
) {
    @Memoized
    String display() {
        "$title by $author ($yearPublished) - ${genres?.join(', ') ?: 'No genres'}"
    }

    @Builder
    Book(String title, String author, String genres) {
        this(title, author, LocalDate.now().year, genres.split(',').toSet())
    }
}

def books = [
    new book1.Book('The Hobbit', 'J.R.R. Tolkien', 1937, ['Fantasy'] as Set),
    new book1.Book('Clean Code', 'Robert C. Martin', 2008, ['Programming'] as Set),
    new book1.Book('1984', 'George Orwell', 1949, ['Dystopian', 'Classic'] as Set),
    book1.Book.builder().title('Prompt Engineering').author('ChatGPT').genres('Nonfiction,AI Writing').build()
]
println books[0]
println books[1].toMap()
// books[2].genres << 'Current Affairs'
println books.sort(false, book1.Book.comparatorByTitle())*.title
println books.sort(false, book1.Book.comparatorByAuthor())*.display().join('\n')
