package com.example.blagostroy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blagostroy.databinding.ServicesItemBinding

class ServicesAdapter():RecyclerView.Adapter<ServicesAdapter.ServicesHolder>() {
    val servicesList = ArrayList<Services>()
    class ServicesHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ServicesItemBinding.bind(item)
        fun bind(services: Services) = with(binding){
            imServices.setImageResource(services.imageId)
            tvNameServices.text = services.title
            tvDescServices.text = services.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.services_item, parent, false)
        return ServicesHolder(view)
    }

    override fun onBindViewHolder(holder: ServicesHolder, position: Int) {
        holder.bind(servicesList[position])
    }

    override fun getItemCount(): Int {
        return servicesList.size
    }

    fun addServices(services: Services){
        servicesList.add(services)
        notifyDataSetChanged()
    }
}