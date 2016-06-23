package com.mk.gifpper.service

import com.mk.gifpper.service.entities.TrendingResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class GiphyApi {
    val endpoint = "http://api.giphy.com/"
    //todo move to props file and pass it to buildconfig
    val apikey = "dc6zaTOxFJmzC"

    val okClient : OkHttpClient = OkHttpClient.Builder().
            addInterceptor { chain ->
                var originalRequest = chain.request()
                var httpURL = originalRequest.url()

                var parametrizedURL = httpURL.newBuilder().addQueryParameter("api_key", apikey).build()
                var modifiedRequest = originalRequest.newBuilder().url(parametrizedURL).build()
                chain.proceed(modifiedRequest)
            }.build()

    val retrofit : Retrofit = Retrofit.Builder().
            addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
            baseUrl(endpoint).
            addConverterFactory(GsonConverterFactory.create()).
            client(okClient).
            build()

    val trendingsApi = retrofit.create(Trendings::class.java)

    val searchApi = retrofit.create(Search::class.java)

    fun loadTrending(offset : Int?, limit : Int?) : Observable<TrendingResponse> {
        return trendingsApi.getTrendings(offset, limit)
    }

    fun searchForGifs(query : String, offset : Int?, limit : Int?) : Observable<TrendingResponse> {
        return searchApi.search(query, offset, limit)
    }

}
