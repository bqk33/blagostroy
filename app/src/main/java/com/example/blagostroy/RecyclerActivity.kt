package com.example.blagostroy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.example.blagostroy.databinding.RecyclerviewTestBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding : RecyclerviewTestBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.tiles1,
        R.drawable.tiles2,
        R.drawable.tiles3,
        R.drawable.tiles4,
        R.drawable.tiles5)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = RecyclerviewTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init()
    }

    //private fun init(){
    //    binding.apply {
    //        rcView.layoutManager = GridLayoutManager(this@RecyclerActivity, 2)
    //        rcView.adapter = adapter
    //        buttonAdd.setOnClickListener {
    //            if (index > 4) index = 0
    //            val plant = Plant(imageIdList[index], "Tiles $index")
    //            adapter.addPlant(plant)
    //            index++
    //        }
    //    }
    //}
}