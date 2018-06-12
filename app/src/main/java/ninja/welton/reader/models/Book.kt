package ninja.welton.reader.models

import ninja.welton.reader.managers.ChapterManager


class Book(id: Int,
           name: String,
           image1: String,
           val image2: String) : AppModel(id, name, image1) {

    val chapters by lazy {
        ChapterManager.getByBook(id)
    }

}