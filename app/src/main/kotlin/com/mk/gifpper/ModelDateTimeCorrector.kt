package com.mk.gifpper

import com.mk.gifpper.service.entities.GifModel

object ModelDateTimeCorrector {
    val ZEROES_PATTERN = Regex.fromLiteral("0000-00-00 00:00:00")
    val SEVENTIES_PATTERN = Regex.fromLiteral("1970-01-01 00:00:00")

    fun correctDatetime (gifModel: GifModel) : GifModel {
        if (gifModel.trendingDatetime.matches(ZEROES_PATTERN) || gifModel.trendingDatetime.matches(SEVENTIES_PATTERN)) {
            gifModel.trendingDatetime = ""
        }
        return gifModel
    }
}