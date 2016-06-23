package com.mk.gifpper.trending

import com.mk.gifpper.BasePresenter
import com.mk.gifpper.BaseView
import com.mk.gifpper.ModelDateTimeCorrector
import com.mk.gifpper.service.GiphyApi
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TrendingPresenter : BasePresenter {
    var currentPage = 0

    var viewInterface: BaseView? = null
    var api = GiphyApi()

    fun setView(view: BaseView) {
        viewInterface = view
    }

    override fun loadMore() {
        api.loadTrending(BasePresenter.PARAMS.PAGE_SIZE * currentPage, BasePresenter.PARAMS.PAGE_SIZE)
                .flatMap { response -> Observable.from(response.data) }
                .map { gifModel -> ModelDateTimeCorrector.correctDatetime(gifModel) }
                .toList()
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ data ->
                    viewInterface?.showData(data)
                    currentPage++
                },
                        { error -> viewInterface?.showError(error?.message ?: "Network request error") })
    }
}