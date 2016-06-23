package com.mk.gifpper

import com.mk.gifpper.service.entities.GifModel

interface BaseView {
    fun showData(result : List<GifModel>)
    fun showError(message : String)
}