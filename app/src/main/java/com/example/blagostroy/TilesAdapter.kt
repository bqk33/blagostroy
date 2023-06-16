package com.example.blagostroy

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blagostroy.databinding.DialogLayoutBinding
import com.example.blagostroy.databinding.TilesItemBinding

class TilesAdapter(): RecyclerView.Adapter<TilesAdapter.TilesHolder>() {
    val tilesList = ArrayList<Tiles>()
    class TilesHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = TilesItemBinding.bind(item)
        fun bind(tiles: Tiles) = with(binding){
            im.setImageResource(tiles.imageId)
            tvTitle.text = tiles.title
            tvTitle2.text = tiles.size
            buttonDesc.setOnClickListener{
                val dialogBuilder = AlertDialog.Builder(itemView.context)
                val dialogView = LayoutInflater.from(itemView.context).inflate(R.layout.dialog_layout, null)
                val dialogBinding = DialogLayoutBinding.bind(dialogView)
                dialogBinding.dialogTitle.text = tiles.title
                dialogBinding.dialogImage.setImageResource(tiles.imageId)
                dialogBinding.dialogTitleDesc.text = "Описание:"
                dialogBinding.dialogTitle2.text = "Размер: ${tiles.size}"
                dialogBinding.dialogTitleCount.text = "Количество м2/шт в пачке: ${tiles.count}"
                dialogBinding.dialogTitleColors.text = " Цвета:\n ${tiles.color}"
                dialogBuilder.setView(dialogView)
                    .setPositiveButton("ОК") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TilesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tiles_item, parent, false)
        return TilesHolder(view)
    }

    override fun onBindViewHolder(holder: TilesHolder, position: Int) {
        holder.bind(tilesList[position])
    }

    override fun getItemCount(): Int {
        return tilesList.size
    }

    fun addTiles(tiles: Tiles){
        tilesList.add(tiles)
        notifyDataSetChanged()
    }
}