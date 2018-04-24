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
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

	override fun onCreate(savedInstanceState: Bundle?) {
		setTheme(when(prefs.theme){
			Themes.Light -> R.style.AppTheme
			Themes.Dark -> R.style.AppThemeDark
		})
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close).also {
			drawer_layout.addDrawerListener(it)
		}.syncState()

		nav_view.setNavigationItemSelectedListener(this)

		main_buttonStart.setOnClickListener {

		}
	}

	override fun onBackPressed() {
		if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
			drawer_layout.closeDrawer(GravityCompat.START)
		} else {
			super.onBackPressed()
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
				startActivity(intentFor<SettingsActivity>())
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		// Handle navigation view item clicks here.
		when (item.itemId) {
			R.id.nav_camera -> {
				// Handle the camera action
			}
			R.id.nav_gallery -> {

			}
			R.id.nav_slideshow -> {

			}
			R.id.nav_manage -> {

			}
			R.id.nav_share -> {

			}
			R.id.nav_send -> {

			}
		}

		drawer_layout.closeDrawer(GravityCompat.START)
		return true
	}
}
