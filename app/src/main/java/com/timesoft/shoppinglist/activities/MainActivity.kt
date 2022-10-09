package com.timesoft.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.timesoft.shoppinglist.R
import com.timesoft.shoppinglist.databinding.ActivityMainBinding
import com.timesoft.shoppinglist.dialogs.NewListDialog
import com.timesoft.shoppinglist.fragments.FragmentManager
import com.timesoft.shoppinglist.fragments.NoteFragment
import com.timesoft.shoppinglist.fragments.ShopListNamesFragment

class MainActivity : AppCompatActivity(), NewListDialog.Listener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentManager.setFragment(ShopListNamesFragment.newInstance(), this)
        setBottomNavListener()
    }

    private fun setBottomNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyLog", "setting")
                }
                R.id.notes -> {
                    FragmentManager.setFragment(NoteFragment.newInstance(), this)
                }
                R.id.shop_list -> {
                    FragmentManager.setFragment(ShopListNamesFragment.newInstance(), this)
                }
                R.id.new_item -> {
                    FragmentManager.currentFragment?.onClickNew()
                }
            }
            true
        }
    }

    override fun onClick(name: String) {
        Log.d("MyLog", "Name: $name")
    }
}