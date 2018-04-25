package ninja.welton.reader.managers

import ninja.welton.reader.models.Book


object BookManager {
    var itens: List<Book> = listOf(
            Book("Livro 1", "http://lorempixel.com/300/300"),
            Book("Livro 2", "http://lorempixel.com/300/300"),
            Book("Livro 3", "http://lorempixel.com/300/300"),
            Book("Livro 4", "http://lorempixel.com/300/300"))

}