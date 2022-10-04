package com.timesoft.shoppinglist.fragments

import androidx.appcompat.app.AppCompatActivity
import com.timesoft.shoppinglist.R

object FragmentManager {
    var currentFragment: BaseFragment? = null

    fun setFragment(newFragment: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager
            .beginTransaction()
        transaction.replace(R.id.container, newFragment)
        transaction.commit()
        currentFragment = newFragment
    }
}