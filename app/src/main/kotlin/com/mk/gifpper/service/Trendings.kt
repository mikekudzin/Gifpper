package com.mk.gifpper.service

import com.mk.gifpper.service.entities.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface Trendings {
    @GET("/v1/gifs/trending")
    fun getTrendings(@Query("offset") offset : Int?, @Query("limit") limit : Int?) : Observable<TrendingResponse>
}