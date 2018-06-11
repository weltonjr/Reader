package ninja.welton.reader.models


class Library(name: String, image: String) : AppModel(name, image) {

    val Books by lazy {
        listOf(
                Book("Livro 1", "http://lorempixel.com/300/300", true),
                Book("Livro 2", "http://lorempixel.com/300/300", false),
                Book("Livro 3", "http://lorempixel.com/300/300", false),
                Book("Livro 4", "http://lorempixel.com/300/300", true))
    }
}