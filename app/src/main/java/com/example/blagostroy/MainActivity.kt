package com.example.blagostroy


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.blagostroy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_fragment, TilesFragment.newInstance())
            .commit()

        bindingClass.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, TilesFragment.newInstance())
                        .commit()
                }
                R.id.item2 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, ServicesFragment.newInstance())
                        .commit()
                }
                R.id.item3 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, GalleryFragment.newInstance())
                        .commit()
                }
                R.id.item4 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_fragment, CalcFragment.newInstance())
                        .commit()
                }
            }
            true
        }
    }

}