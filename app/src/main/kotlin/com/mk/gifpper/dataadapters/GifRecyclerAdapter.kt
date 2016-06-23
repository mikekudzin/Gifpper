package com.mk.gifpper.dataadapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mk.gifpper.databinding.GifCollectionViewElementBinding
import com.mk.gifpper.service.entities.GifModel
import java.util.*

class GifRecyclerAdapter : RecyclerView.Adapter<GifCollectionViewElementViewHolder>() {
    var data: ArrayList<GifModel> = ArrayList()

    fun updateData(newData: List<GifModel>) {
        data.clear();
        data.addAll(newData)
        notifyDataSetChanged()
    }

    fun addData(newData: List<GifModel>) {
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GifCollectionViewElementViewHolder?, position: Int) {
        var gifModel: GifModel = data[position]
        holder?.binding?.gifModel = gifModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifCollectionViewElementViewHolder? {
        var inflater = LayoutInflater.from(parent.context)
        var binding = GifCollectionViewElementBinding.inflate(inflater, parent, false)
        return GifCollectionViewElementViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onViewRecycled(holder: GifCollectionViewElementViewHolder) {
        super.onViewRecycled(holder)
        Glide.clear(holder.binding.img)
        holder.binding.img.setImageDrawable(null)
    }

    override fun onViewDetachedFromWindow(holder: GifCollectionViewElementViewHolder?) {
        super.onViewDetachedFromWindow(holder)
    }
}
