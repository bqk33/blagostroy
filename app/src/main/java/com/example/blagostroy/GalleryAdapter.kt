package com.example.blagostroy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blagostroy.databinding.GalleryItemBinding

class GalleryAdapter(): RecyclerView.Adapter<GalleryAdapter.GalleryHolder>() {
    val galleryList = ArrayList<Gallery>()
    class GalleryHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = GalleryItemBinding.bind(item)
        fun bind(gallery: Gallery) = with(binding){
            imGallery.setImageResource(gallery.imageId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return GalleryHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryHolder, position: Int) {
        holder.bind(galleryList[position])
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    fun addGallery(gallery: Gallery){
        galleryList.add(gallery)
        notifyDataSetChanged()
    }
}