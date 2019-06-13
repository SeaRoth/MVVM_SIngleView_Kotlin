package com.searoth.adesa

import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {



    fun showSnackBar(str: String) {
        val rootView = this.window.decorView.findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, str, Snackbar.LENGTH_LONG).show()
    }

    open fun inflateOptionsMenu(menu: Menu) {
        return menuInflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                finish(); return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}