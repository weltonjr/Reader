package ninja.welton.reader.models


class Chapter(title: String, val text: String, val done: Boolean = false) : AppModel(title, null)