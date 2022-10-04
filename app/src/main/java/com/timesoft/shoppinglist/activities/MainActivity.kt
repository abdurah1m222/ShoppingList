package com.timesoft.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.timesoft.shoppinglist.R
import com.timesoft.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()
    }

    private fun setBottomNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyLog","setting")
                }
                R.id.notes -> {
                    Log.d("MyLog","notes")
                }
                R.id.shop_list -> {
                    Log.d("MyLog","shop_list")
                }
                R.id.new_item -> {
                    Log.d("MyLog","new_item")
                }
            }
            true
        }
    }

}