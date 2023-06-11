package com.example.blagostroy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.blagostroy.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    //адаптер и список
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.tiles1,
        R.drawable.tiles2,
        R.drawable.tiles3,
        R.drawable.tiles4,
        R.drawable.tiles5)
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
        init()
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(requireContext(), 2)
            rcView.adapter = adapter
            buttonTest.setOnClickListener {
                if (index > 4) index = 0
                val plant = Plant(imageIdList[index], "Tiles $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }

}