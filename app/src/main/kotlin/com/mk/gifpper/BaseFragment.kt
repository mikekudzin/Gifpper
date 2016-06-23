package com.mk.gifpper

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mk.gifpper.dataadapters.GifRecyclerAdapter
import com.mk.gifpper.service.entities.GifModel

abstract class BaseFragment<T : BasePresenter> : Fragment(), BaseView, ToEndScrollDetector.OnListScrolledToEndListener {
    var dataAdapter: GifRecyclerAdapter? = null
    var presenter: T? = null
    var loading = false

    override fun showData(result: List<GifModel>) {
        dataAdapter?.addData(result)
        loading = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        dataAdapter = GifRecyclerAdapter()
        presenter = createPresenter()
        presenter?.loadMore()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.search_fragment, container, false)
        val recycler = rootView.findViewById(R.id.recycler) as RecyclerView
        recycler.adapter = dataAdapter
        recycler.addOnScrollListener(ToEndScrollDetector(this))
        return rootView
    }

    abstract fun createPresenter():  T?

    override fun onListScrolledToEnd() {
        if (loading) {
            return
        }
        presenter?.loadMore()
        loading = true
    }

    override fun showError(message: String) {
        if (activity != null) Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}