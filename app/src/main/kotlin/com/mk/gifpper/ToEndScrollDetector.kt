package com.mk.gifpper

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.OnScrollListener

class ToEndScrollDetector(handler: OnListScrolledToEndListener) : OnScrollListener() {
    interface OnListScrolledToEndListener {
        fun onListScrolledToEnd()
    }

    val handler: OnListScrolledToEndListener
    var layoutManager : LinearLayoutManager? = null

    init {
        this.handler = handler
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        layoutManager = layoutManager ?: recyclerView.layoutManager as LinearLayoutManager
        var totalItems = layoutManager?.itemCount?: 0
        var lastVisibleIdx = layoutManager?.findLastVisibleItemPosition()

        if (lastVisibleIdx == (totalItems - 1)) handler.onListScrolledToEnd();
    }
}