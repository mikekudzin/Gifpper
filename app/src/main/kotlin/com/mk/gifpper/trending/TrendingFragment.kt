package com.mk.gifpper.trending

import com.mk.gifpper.BaseFragment

class TrendingFragment : BaseFragment<TrendingPresenter>() {
    override fun createPresenter(): TrendingPresenter? {
        var presenter = TrendingPresenter()
        presenter.setView(this)
        return presenter
    }

    object Holder {
        val TAG = TrendingFragment::class.java.simpleName
    }

}