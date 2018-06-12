package ninja.welton.reader.managers

import ninja.welton.reader.models.Book
import ninja.welton.reader.models.Chapter


object BookManager {

    fun getByLibrary(idLibrary: Int): List<Book> {
        return listOf(
                Book(0,"Livro 1f", "http://lorempixel.com/300/300"),
                Book(1,"Livro 2", "http://lorempixel.com/300/300"),
                Book(2,"Livro 3", "http://lorempixel.com/300/300"),
                Book(3,"Livro 4f", "http://lorempixel.com/300/300"))
    }

    fun getById(idBook: Int): Book {
        return Book(0,"Livro 1f", "http://lorempixel.com/300/300")
    }

    fun getByIds(ids: List<Int>): List<Book> {
        return listOf(
                Book(0,"Livro 1f", "http://lorempixel.com/300/300"),
                Book(1,"Livro 2", "http://lorempixel.com/300/300"),
                Book(2,"Livro 3", "http://lorempixel.com/300/300"),
                Book(3,"Livro 4f", "http://lorempixel.com/300/300"))
    }
}