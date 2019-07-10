Book fiona = new Book('The name of the wind')
assert fiona.getTitle() == 'The name of the wind'
assert getTitleBackwards(fiona) == 'dniw eht fo eman ehT'

String getTitleBackwards(book) {

String title = book.getTitle()
println title
return title.reverse()
}