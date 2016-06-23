package com.mk.gifpper.service

import com.mk.gifpper.service.entities.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface Search {
    @GET("/v1/gifs/search")
    fun search(@Query("q") searchQuery : String, @Query("offset") offset : Int?, @Query("limit") limit : Int?) : Observable<TrendingResponse>
}