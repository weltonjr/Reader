package ninja.welton.reader.managers

import ninja.welton.reader.models.Library


object LibraryManager {

    val libraries by lazy {
        listOf(
                Library(20,"Teste 1", "http://lorempixel.com/300/300"),
                Library(21,"Teste 2", "http://lorempixel.com/300/300"),
                Library(22,"Teste 3", "http://lorempixel.com/300/300"),
                Library(23,"Teste 4", "http://lorempixel.com/300/300"),
                Library(24,"Teste 5", "http://lorempixel.com/300/300"),
                Library(25,"Teste 6", "http://lorempixel.com/300/300"),
                Library(26,"Teste 7", "http://lorempixel.com/300/300"))
    }
}