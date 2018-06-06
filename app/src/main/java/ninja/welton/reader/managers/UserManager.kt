package ninja.welton.reader.managers

import ninja.welton.reader.models.Book


object UserManager {
    val user by lazy{
        ""
    }

    val favs by lazy{
        BookManager.books
    }
}