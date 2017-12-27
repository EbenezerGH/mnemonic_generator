package jfyg.mnemonic.generator

import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import jfyg.mnemonic.generator.bip39.Bip39Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


open class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        actionbarToggle()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun actionbarToggle() {
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_suggestions -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_bip44 -> {
                openBip44Fragment()
            }
            R.id.nav_2 -> {

            }
            R.id.nav_3 -> {

            }
            R.id.nav_4 -> {

            }
            R.id.nav_5 -> {

            }
            R.id.nav_6 -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun openBip44Fragment() {
        val bip44Fragment = Bip39Fragment()
        val transaction = fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, bip44Fragment)

        transaction.commit()
    }

}
