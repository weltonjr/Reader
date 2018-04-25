package ninja.welton.reader

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

	private var backTimer = 0L
	private val maxTimeBettwenBackClicks = 2000

	override fun onCreate(savedInstanceState: Bundle?) {
		setTheme(when(prefs.theme){
			Themes.Light -> R.style.AppTheme
			Themes.Dark -> R.style.AppThemeDark
		})
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		supportFragmentManager.beginTransaction().also {
			it.replace(R.id.main_content, HomeFragment(), "HOME")
		}.commit()

		if(intent.extras != null && intent.extras.getBoolean("themeChange", false))	//Se for troca de tema, avança pro fragmento de configurações
			supportFragmentManager.beginTransaction().also {
				it.replace(R.id.main_content, SettingsFragment(), "HOME")
			}.commit()


		ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close).also {
			drawer_layout.addDrawerListener(it)
		}.syncState()

		nav_view.setNavigationItemSelectedListener(this)

	}

	override fun onBackPressed() {
		if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
			drawer_layout.closeDrawer(GravityCompat.START)
		} else {
			if(backTimer + maxTimeBettwenBackClicks > System.currentTimeMillis())
				super.onBackPressed()
			else{
				backTimer = System.currentTimeMillis()
				toast(R.string.click_back_again)
			}
		}
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.action_settings -> {
				supportFragmentManager.beginTransaction().also {
					it.addToBackStack("HOME")
					it.replace(R.id.main_content, SettingsFragment())
				}.commit()
				true
			}
			R.id.action_about -> {
				supportFragmentManager.beginTransaction().also {
					it.addToBackStack("HOME")
					it.replace(R.id.main_content, AboutFragment())
				}.commit()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.nav_library -> supportFragmentManager.beginTransaction().also {
				it.addToBackStack("HOME")
				it.replace(R.id.main_content, LibraryFragment())
			}.commit()

			R.id.nav_about -> supportFragmentManager.beginTransaction().also {
				it.addToBackStack("HOME")
				it.replace(R.id.main_content, AboutFragment())
			}.commit()
	}

		drawer_layout.closeDrawer(GravityCompat.START)
		return true
	}
}
