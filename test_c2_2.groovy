// 2016-07-06

Book b = new Book('Groovy in Action')

assert b.getTitle() == 'Groovy in Action'
assert reverseTitle(b) == 'noitcA ni yvoorG'

String reverseTitle(Book book) {
  return book.getTitle().reverse()
}
