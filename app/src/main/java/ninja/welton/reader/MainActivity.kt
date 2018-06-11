package ninja.welton.reader


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ninja.welton.reader.extensions.inTransaction
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private var backTimer = 0L
    private val maxTimeBettwenBackClicks = 2000L

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.inTransaction {
                    replace(R.id.mainFrameLayout, HomeFragment(), HomeFragment::class.simpleName)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.inTransaction {
                    replace(R.id.mainFrameLayout, LibraryFragment(), LibraryFragment::class.simpleName)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.inTransaction {
                    replace(R.id.mainFrameLayout, SettingsFragment(), SettingsFragment::class.simpleName)
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onBackPressed() {
        if(backTimer + maxTimeBettwenBackClicks > System.currentTimeMillis())
            super.onBackPressed();
        else {
            backTimer = System.currentTimeMillis()
            toast(R.string.click_back_again)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(when(prefs.theme){
            Themes.Light -> R.style.AppTheme
            Themes.Dark -> R.style.AppThemeDark
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.inTransaction {
            if(intent.extras != null && intent.extras.getBoolean("themeChange", false)) {    //Se for troca de tema, avança pro fragmento de configurações
                replace(R.id.mainFrameLayout, SettingsFragment(), SettingsFragment::class.simpleName)
                //todo: mudar seleção na navegação inferior
            }else
                replace(R.id.mainFrameLayout, HomeFragment(), HomeFragment::class.simpleName)
        }

    }
}
