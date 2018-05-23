package ninja.welton.reader.managers

import ninja.welton.reader.models.Book


object BookManager {

    fun getBooks(): List<Book>{
        return listOf(
                Book("Livro 1", "http://lorempixel.com/300/300", true),
                Book("Livro 2", "http://lorempixel.com/300/300", false),
                Book("Livro 3", "http://lorempixel.com/300/300", false),
                Book("Livro 4", "http://lorempixel.com/300/300", true))
    }
}