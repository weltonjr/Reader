package ninja.welton.reader

import android.content.Context
import android.content.SharedPreferences

private const val PREFS_FILENAME = "ninja.welton.classLog.prefs"
private const val THEME = "theme"

class Prefs (context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var theme: Themes
        get() = Themes.valueOf( prefs.getString(THEME, Themes.Light.name))
        set(value) = prefs.edit().putString(THEME, value.name).apply()
}

public enum class Themes{
    Light,
    Dark
}