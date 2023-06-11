package com.example.blagostroy

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blagostroy.databinding.DialogLayoutBinding
import com.example.blagostroy.databinding.PlantItemBinding

class PlantAdapter(): RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    val plantList = ArrayList<Plant>()
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title
            buttonDesc.setOnClickListener{
                val dialogBuilder = AlertDialog.Builder(itemView.context)
                val dialogView = LayoutInflater.from(itemView.context).inflate(R.layout.dialog_layout, null)
                val dialogBinding = DialogLayoutBinding.bind(dialogView)
                dialogBinding.dialogTitle.text = plant.title
                dialogBinding.dialogImage.setImageResource(plant.imageId)
                dialogBuilder.setView(dialogView)
                    .setPositiveButton("ОК") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}