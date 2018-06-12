package ninja.welton.reader.models

import ninja.welton.reader.managers.BookManager


class Library(id: Int, name: String, image: String) : AppModel(id, name, image) {

    val books by lazy {
        BookManager.getByLibrary(id)
    }
}