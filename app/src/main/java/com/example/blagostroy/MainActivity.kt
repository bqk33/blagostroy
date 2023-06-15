package com.example.blagostroy


import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.blagostroy.databinding.ActivityMainBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File


class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

//        loadAndDisplayImage()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_fragment, BlankFragment.newInstance())
            .commit()

        bindingClass.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, BlankFragment.newInstance())
                        .commit()
                    Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show()
                }
                R.id.item2 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, BlankFragment2.newInstance())
                        .commit()
                    Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show()
                }
                R.id.item3 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, BlankFragment3.newInstance())
                        .commit()
                    Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show()
                }
                R.id.item4 -> {
                    Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

}