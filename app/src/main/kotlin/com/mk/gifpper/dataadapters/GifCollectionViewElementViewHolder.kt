package com.mk.gifpper.dataadapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.mk.gifpper.databinding.GifCollectionViewElementBinding

class GifCollectionViewElementViewHolder : RecyclerView.ViewHolder {

    var binding: GifCollectionViewElementBinding

    constructor(itemView: View) : super(itemView) {
        binding = DataBindingUtil.bind(itemView)
    }

}