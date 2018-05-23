package ninja.welton.reader

import android.app.Application
import com.google.firebase.auth.FirebaseAuth

class App : Application() {
    companion object {
        var prefs: Prefs? = null
        var auth: FirebaseAuth? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)

//        auth = FirebaseAuth.getInstance()

        super.onCreate()
    }
}

val prefs: Prefs by lazy {
    App.prefs!!
}