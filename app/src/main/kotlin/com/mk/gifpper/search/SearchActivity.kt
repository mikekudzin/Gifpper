package com.mk.gifpper.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.mk.gifpper.R

class SearchActivity : AppCompatActivity() {
    val fragmentTag : String = SearchFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(fragmentTag)
        if (fragment == null) {
            fragment = SearchFragment()
            supportFragmentManager.beginTransaction().add(R.id.container, fragment, fragmentTag).commit()
        }
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
