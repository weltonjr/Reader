package ninja.welton.reader.models


class Chapter(id: Int, title: String, val text: String?, val done: Boolean = false) : AppModel(id, title, null)