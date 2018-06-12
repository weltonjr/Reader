package ninja.welton.reader

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_book.*
import ninja.welton.reader.managers.BookManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class BookActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(when(prefs.theme){
            Themes.Light -> R.style.AppTheme
            Themes.Dark -> R.style.AppThemeDark
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        intent.extras?.let{

            it.getString("book", null)?.let{ modelName ->

                BookManager.books.find { it.name == modelName }?.let{book ->

                    //app_bar_image
                    toolbar.title = book.name

                    bookRecyclerView.layoutManager = LinearLayoutManager(this)
                    bookRecyclerView.adapter = ModelRecyclerViewAdapter(book.chapters, R.layout.item_chapter) { _, chapter ->
                        //chamar activity
                        info { "Click on ${chapter.name}" }

                        startActivity(Intent(this, BookActivity::class.java).also {
                            it.putExtra("book", book.name)
                            it.putExtra("chapter", chapter.name)
                        })
                    }
                }
            }
        }
    }
}
