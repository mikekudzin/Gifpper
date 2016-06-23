package com.mk.gifpper.search

import com.mk.gifpper.BasePresenter

interface SearchPresenter : BasePresenter {
    fun submitQueryRequest(query : String)
}