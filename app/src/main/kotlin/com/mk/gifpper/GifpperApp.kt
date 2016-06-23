package com.mk.gifpper

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class GifpperApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}