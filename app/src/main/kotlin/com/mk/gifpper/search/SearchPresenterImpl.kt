package com.mk.gifpper.search

import android.util.Log
import com.mk.gifpper.BasePresenter
import com.mk.gifpper.ModelDateTimeCorrector
import com.mk.gifpper.service.GiphyApi
import com.mk.gifpper.service.entities.GifModel
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SearchPresenterImpl : SearchPresenter {

    val api = GiphyApi()
    val view: SearchView
    var currentPage = 0
    var querySubscription: Subscription? = null
    var query: String = ""

    constructor(view: SearchView) {
        this.view = view;
    }

    override fun submitQueryRequest(query: String) {
        if (querySubscription != null) {
            querySubscription?.isUnsubscribed ?: querySubscription?.unsubscribe()
        }
        this.query = query.trim()
        querySubscription = createRequestObservable(this.query, 0, BasePresenter.PARAMS.PAGE_SIZE)
                .subscribe ({ found ->
                    onSearchFinished(found)
                    currentPage = 1
                },
                        { error ->
                            Log.d("Giphy", "Network error occurred " + error?.cause + " " + error?.message)
                            onNetworkError(error?.message)
                        })
    }

    override fun loadMore() {
        //if we are already running either load more or new search request
        if (querySubscription != null) {
            querySubscription?.isUnsubscribed ?: return;
        }

        querySubscription = createRequestObservable(this.query, currentPage * BasePresenter.PARAMS.PAGE_SIZE, BasePresenter.PARAMS.PAGE_SIZE)
                .subscribe ({ result ->
                    view.showData(result)
                    currentPage++
                },
                        { error -> onNetworkError(error?.message) })
    }

    fun createRequestObservable(query: String, offset: Int, limit: Int): Observable<List<GifModel>> {
        var observable = api.searchForGifs(query.trim(), 0, BasePresenter.PARAMS.PAGE_SIZE)
                .flatMap { response -> Observable.from(response.data) }
                .filter { gifModel ->
                    var rating = gifModel.rating
                    rating.equals("y") || rating.equals("g") || rating.equals("pg")
                }
                .map { gifModel -> ModelDateTimeCorrector.correctDatetime(gifModel) }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        return observable
    }

    fun onSearchFinished(result: List<GifModel>) {
        view.showSearchResult(result)
    }

    fun onNetworkError(message: String?) {
        view.showError(message ?: "Network error occurred")
    }
}