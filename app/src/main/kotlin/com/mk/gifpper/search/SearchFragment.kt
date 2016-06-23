package com.mk.gifpper.search

import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import com.mk.gifpper.BaseFragment
import com.mk.gifpper.R
import com.mk.gifpper.service.entities.GifModel

class SearchFragment : BaseFragment<SearchPresenter>(), com.mk.gifpper.search.SearchView, SearchView.OnQueryTextListener {

    override fun showSearchResult(searchResult: List<GifModel>) {
        dataAdapter?.updateData(searchResult)
    }

    var searchView : SearchView? = null
    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter?.submitQueryRequest(query ?: "")
        searchView?.clearFocus()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false;
    }

    override fun createPresenter(): SearchPresenter {
        return SearchPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.search_menu, menu)
        searchView = MenuItemCompat.getActionView(menu?.findItem(R.id.search)) as SearchView
        searchView?.isIconified = false
        searchView?.setOnQueryTextListener(this)
    }
}