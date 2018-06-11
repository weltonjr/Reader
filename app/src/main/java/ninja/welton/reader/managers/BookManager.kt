package ninja.welton.reader.managers

import ninja.welton.reader.models.Book
import ninja.welton.reader.models.Chapter


object BookManager {

    val books by lazy{
        //todo: recuperar baseado na biblioteca
         listOf(
            Book("Livro 1f", "http://lorempixel.com/300/300", true),
            Book("Livro 2", "http://lorempixel.com/300/300", false),
            Book("Livro 3", "http://lorempixel.com/300/300", false),
            Book("Livro 4f", "http://lorempixel.com/300/300", true))
    }
}