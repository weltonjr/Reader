package ninja.welton.reader.managers

import ninja.welton.reader.models.Book
import ninja.welton.reader.prefs


object UserManager {
    val user by lazy{
        ""
    }

    //Favorites
    fun toogleFavorite(idBook: Int){
        var favorites = prefs.favoriteBooks

        if(favorites.contains(idBook.toString())){
            favorites += idBook.toString()
        }
        else{
            favorites -= idBook.toString()
        }
        prefs.favoriteBooks = favorites
    }

    fun favoriteBooks() = BookManager.getByIds(prefs.favoriteBooks.map { it.toInt() })

}