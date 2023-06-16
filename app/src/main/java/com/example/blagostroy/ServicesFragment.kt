package com.example.blagostroy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.blagostroy.databinding.FragmentServicesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ServicesFragment : Fragment() {
    lateinit var bindingServices: FragmentServicesBinding
    private val adapter = ServicesAdapter()
    private val imageIdList = listOf(
        R.drawable.services1,
        R.drawable.services2,
        R.drawable.services3,
        R.drawable.services4,
        R.drawable.services5)
    private val nameList = mutableListOf<String>()
    private val descList = mutableListOf<String>()
    private var index = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingServices = FragmentServicesBinding.inflate(inflater)
        return bindingServices.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ServicesFragment() }

    fun loadData(){
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("services")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (childSnapshot in dataSnapshot.children) {
                    val nameServices = childSnapshot.child("name").getValue(String::class.java)
                    val descServices = childSnapshot.child("desc").getValue(String::class.java)
                    if (nameServices != null && descServices != null) {
                        nameList.add(nameServices.toString())
                        descList.add(descServices.toString())
                    }
                }
                if (isAdded) {
                    init()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Failed to read value.", error.toException())
                if (isAdded) {
                    init()
                }
            }
        })
    }


    private fun init(){
        bindingServices.apply {
            rcViewServices.layoutManager = GridLayoutManager(requireContext(), 1)
            rcViewServices.adapter = adapter
            var maxIndex = imageIdList.size
            while(index < maxIndex){
                val services = Services(imageIdList[index], nameList[index], descList[index])
                adapter.addServices(services)
                index++
            }
        }
    }
}