package com.example.blagostroy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.blagostroy.databinding.FragmentBlankBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    //адаптер и список
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.tiles1,
        R.drawable.tiles2,
        R.drawable.tiles3,
        R.drawable.tiles4,
        R.drawable.tiles5,
        R.drawable.tiles6,
        R.drawable.tiles7,
        R.drawable.tiles8)
    private val nameList = mutableListOf<String>()
    private val sizeList = mutableListOf<String>()
    private val colorList = mutableListOf<String>()
    private val countList = mutableListOf<String>()
    private var index = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        blago()
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }

    fun blago(){
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("tiles")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (childSnapshot in dataSnapshot.children) {
                    val nameTiles = childSnapshot.child("name").getValue(String::class.java)
                    val sizeTiles = childSnapshot.child("size").getValue(String::class.java)
                    val countTiles = childSnapshot.child("countInPack").getValue(String::class.java)
                    val colorTiles = childSnapshot.child("color").getValue(String::class.java)
                    val formattedColorTiles = colorTiles?.replace(".", ". \n")
                    if (nameTiles != null && sizeTiles != null && formattedColorTiles != null && countTiles != null) {
                        nameList.add(nameTiles.toString())
                        sizeList.add(sizeTiles.toString())
                        colorList.add(formattedColorTiles.toString())
                        countList.add(countTiles.toString())
                        Log.d("Firebase", "Name: $nameTiles")
                        Log.d("Firebase", "Name: $sizeTiles")
                    }
                }

                // Вывод элементов списка в Toast сообщениях
                Log.d("Firebase", "Size: ${nameList.size}")
                Log.d("Firebase", "Size: ${sizeList.size}")
                if (isAdded) { // Проверяем, присоединен ли фрагмент
                    init()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Failed to read value.", error.toException())
                if (isAdded) { // Проверяем, присоединен ли фрагмент
                    init()
                }
            }
        })
    }


    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(requireContext(), 2)
            rcView.adapter = adapter
            while(index < 8){
                val plant = Plant(imageIdList[index], nameList[index], sizeList[index], colorList[index], countList[index])
                adapter.addPlant(plant)
                index++
            }
        }
    }

}
