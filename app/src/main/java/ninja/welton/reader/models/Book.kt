package ninja.welton.reader.models


class Book(name: String,
           image: String,
           var favorite: Boolean = false) : AppModel(name, image){


    val chapters by lazy{
        //todo: recuperar baseado no livro

        listOf( Chapter("Capitulo 1"),
                Chapter("Capitulo 2"),
                Chapter("Capitulo 3"),
                Chapter("Capitulo 4"),
                Chapter("Capitulo 5"),
                Chapter("Capitulo 6"),
                Chapter("Capitulo 7"),
                Chapter("Capitulo 8"))

    }



}