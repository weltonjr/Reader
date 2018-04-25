package ninja.welton.reader


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import android.support.v4.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_settings, container, false)



    override fun onStart() {
        toggle_theme.isChecked = when(prefs.theme){
                    Themes.Light -> false
                    Themes.Dark -> true
                }

        toggle_theme.setOnClickListener{
            prefs.theme = if (toggle_theme.isChecked) Themes.Dark else Themes.Light

            activity.setTheme(when(prefs.theme){
                Themes.Light -> R.style.AppTheme
                Themes.Dark -> R.style.AppThemeDark
            })
            activity.finish()
            activity.startActivity(Intent(activity, MainActivity::class.java).also {
                it.putExtra("themeChange", true)
            })
        }
        super.onStart()
    }
}
