trait Notable {
    String note
}

trait Timestamped {
    Date created = new Date()
}

class MyList extends ArrayList implements Notable, Timestamped {}

def shopping = new MyList(note: 'groceries for weekend')
shopping += ['🍞', '🍶', '🍎']
assert shopping.size() == 3
assert shopping.note == 'groceries for weekend'
assert shopping.created.format('EEEE').endsWith('y')
