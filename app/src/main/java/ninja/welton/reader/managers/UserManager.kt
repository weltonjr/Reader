package ninja.welton.reader.managers

import ninja.welton.reader.models.Book


object UserManager {
    val user by lazy{
        ""
    }

    val favoriteBooks by lazy{
        BookManager.books.filter { it.favorite }
    }
}