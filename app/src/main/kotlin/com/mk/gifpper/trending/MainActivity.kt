package com.mk.gifpper.trending

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import butterknife.BindView
import com.mk.gifpper.R
import com.mk.gifpper.dataadapters.GifRecyclerAdapter
import com.mk.gifpper.search.SearchActivity
import com.mk.gifpper.service.entities.GifModel

class MainActivity : AppCompatActivity() {

    @BindView(R.id.recycler) lateinit var recycler: RecyclerView
    lateinit var dataAdapter: GifRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        var toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportFragmentManager.findFragmentByTag(TrendingFragment.Holder.TAG)
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(TrendingFragment.Holder.TAG)
        if (fragment == null) {
            fragment = TrendingFragment()
            supportFragmentManager.beginTransaction().add(R.id.container, fragment, TrendingFragment.Holder.TAG).commit()
        }

    }

    fun showGifs(gifModels: List<GifModel>) {
        dataAdapter.updateData(gifModels)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search) {
            val intent = Intent(applicationContext, SearchActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
