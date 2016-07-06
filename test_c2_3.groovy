class Book {
  String title
}

Book book = new Book()

book.setTitle('Groovy conquers the world')
assert book.getTitle() == 'Groovy conquers the world'

book.title = 'Groovy in Action'
assert book.title == 'Groovy in Action'
