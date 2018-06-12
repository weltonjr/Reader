package ninja.welton.reader

import android.app.Application

//import com.google.firebase.auth.FirebaseAuth

const val API = "http://welton.ninja/umbraco/surface/Reader"
const val IMAGE = "http://welton.ninja"

class App : Application() {
    companion object {
        var prefs: Prefs? = null
//        var auth: FirebaseAuth? = null
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