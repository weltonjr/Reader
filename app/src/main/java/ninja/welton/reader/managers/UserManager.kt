package ninja.welton.reader.managers

import ninja.welton.reader.models.Book


object UserManager {
    val user by lazy{
        ""
    }

    fun getFavs(): List<Book>{

        return BookManager.getBooks()
    }
}