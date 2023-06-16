package com.example.blagostroy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.blagostroy.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    lateinit var bindingGallery: FragmentGalleryBinding
    private val adapter = GalleryAdapter()
    private val imageIdList = listOf(
        R.drawable.gallery1, R.drawable.gallery2, R.drawable.gallery3,
        R.drawable.gallery4, R.drawable.gallery5, R.drawable.gallery6,
        R.drawable.gallery7, R.drawable.gallery8, R.drawable.gallery9,
        R.drawable.gallery10, R.drawable.gallery12,
        R.drawable.gallery15,
        R.drawable.gallery16, R.drawable.gallery17,
        R.drawable.gallery20, R.drawable.gallery21,
        R.drawable.gallery22, R.drawable.gallery23, R.drawable.gallery24,
        R.drawable.gallery25, R.drawable.gallery26)
    private var index = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingGallery = FragmentGalleryBinding.inflate(inflater)
        return bindingGallery.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = GalleryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        bindingGallery.apply {
            rcViewGallery.layoutManager = GridLayoutManager(requireContext(), 1)
            rcViewGallery.adapter = adapter
            var maxIndex = imageIdList.size
            while(index < maxIndex){
                val gallery = Gallery(imageIdList[index])
                adapter.addGallery(gallery)
                index++
            }
        }
    }
}