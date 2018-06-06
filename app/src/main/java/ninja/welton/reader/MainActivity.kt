package ninja.welton.reader


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ninja.welton.reader.extensions.inTransaction

class MainActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.inTransaction {
            add(R.id.mainFrameLayout, HomeFragment(), HomeFragment::class.simpleName)
        }

    }
}
