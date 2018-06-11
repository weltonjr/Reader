package ninja.welton.reader.models


class Book(name: String,
           image: String,
           var favorite: Boolean = false) : AppModel(name, image){


    val chapters by lazy{
        //todo: recuperar baseado no livro

        listOf( Chapter("Capitulo 1", "lorem ipsum"),
                Chapter("Capitulo 2", "lorem ipsum"),
                Chapter("Capitulo 3", "lorem ipsum"),
                Chapter("Capitulo 4", "lorem ipsum"),
                Chapter("Capitulo 5", "lorem ipsum"),
                Chapter("Capitulo 6", "lorem ipsum"),
                Chapter("Capitulo 7", "lorem ipsum"),
                Chapter("Capitulo 8", "lorem ipsum"))

    }



}