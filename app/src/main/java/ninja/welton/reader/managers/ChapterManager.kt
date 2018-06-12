package ninja.welton.reader.managers

import ninja.welton.reader.models.Chapter


object ChapterManager {

    fun getByBook(idBook: Int): List<Chapter> {
        return listOf(
                Chapter(0, "Capitulo 1", "lorem ipsum"),
                Chapter(1, "Capitulo 2", "lorem ipsum"),
                Chapter(2, "Capitulo 3", "lorem ipsum"),
                Chapter(3, "Capitulo 4", "lorem ipsum"),
                Chapter(4, "Capitulo 5", "lorem ipsum"),
                Chapter(5, "Capitulo 6", "lorem ipsum"),
                Chapter(6, "Capitulo 7", "lorem ipsum"),
                Chapter(7, "Capitulo 8", "lorem ipsum"))
    }

    fun getById(idBook: Int): Chapter {
        return Chapter(0,"Capitulo 1", "lorem ipsum")
    }
}