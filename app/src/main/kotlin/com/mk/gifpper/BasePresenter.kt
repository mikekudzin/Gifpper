package com.mk.gifpper

interface BasePresenter{
    object PARAMS {
        val PAGE_SIZE = 25
    }
    fun loadMore()
}