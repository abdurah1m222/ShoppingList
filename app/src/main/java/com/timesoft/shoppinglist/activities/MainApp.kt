package com.timesoft.shoppinglist.activities

import android.app.Application
import com.timesoft.shoppinglist.db.MainDatabase

class MainApp : Application() {
    val database by lazy { MainDatabase.getDataBase(this) }
}