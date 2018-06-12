package ninja.welton.reader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chapter.*
import ninja.welton.reader.managers.ChapterManager

class ChapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(when(prefs.theme){
            Themes.Light -> R.style.AppTheme
            Themes.Dark -> R.style.AppThemeDark
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        intent.extras?.let{

            ChapterManager.getById(it.getInt("chapter", -1))?.let{chapter ->
                supportActionBar?.title = chapter.name

                webView.loadData(
                        """<html>
                                <body style="background: ${if (prefs.theme == Themes.Dark) "#313031" else "#fafafa"};
                                             color: ${if (prefs.theme == Themes.Dark) "#fafafa" else "#313031"};">

                                    ${chapter.text}
                                </body>
                            </html>
                            """, "text/html; charset=utf-8", "utf-8")

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
