package ninja.welton.reader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ninja.welton.reader.managers.BookManager

class ChapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(when(prefs.theme){
            Themes.Light -> R.style.AppTheme
            Themes.Dark -> R.style.AppThemeDark
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        intent.extras?.let{

            it.getString("model", null)?.let{ modelName ->

                BookManager.books.find { it.name == modelName }?.let{ model ->

                    //app_bar_image
                    //toolbar.title = model.name

                }
            }
        }
    }
}
