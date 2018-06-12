package ninja.welton.reader.models

import ninja.welton.reader.managers.ChapterManager


class Book(id: Int,
           name: String,
           image: String) : AppModel(id, name, image) {


    val chapters by lazy {
        ChapterManager.getByBook(id)
    }

}