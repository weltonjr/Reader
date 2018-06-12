package ninja.welton.reader

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_book.*
import ninja.welton.reader.managers.BookManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.net.URL

class BookActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(when(prefs.theme){
            Themes.Light -> R.style.AppTheme
            Themes.Dark -> R.style.AppThemeDark
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        intent.extras?.let{

            BookManager.getById(it.getInt("book", 0))?.let{book ->
                val url = URL("$IMAGE${book.image2}")
                val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                app_bar_image.setImageBitmap(bmp)
                supportActionBar?.title = book.name

                bookRecyclerView.layoutManager = LinearLayoutManager(this)
                bookRecyclerView.adapter = ModelRecyclerViewAdapter(book.chapters, R.layout.item_chapter) { _, chapter ->
                    //chamar activity
                    info { "Click on ${chapter.name}" }

                    startActivity(Intent(this, ChapterActivity::class.java).also {
                        it.putExtra("chapter", chapter.id)
                    })
                }

                //todo: fazer este fab
//                fab_toggleFavorite.setOnClickListener {
//                    UserManager.toogleFavorite(book.id)
//                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
