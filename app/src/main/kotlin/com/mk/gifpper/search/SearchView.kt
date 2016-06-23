package com.mk.gifpper.search

import com.mk.gifpper.BaseView
import com.mk.gifpper.service.entities.GifModel

interface SearchView : BaseView {
    fun showSearchResult(searchResult : List<GifModel>)
}