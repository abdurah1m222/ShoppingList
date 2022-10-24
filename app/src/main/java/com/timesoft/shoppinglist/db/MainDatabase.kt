package com.timesoft.shoppinglist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.timesoft.shoppinglist.entities.LibraryItem
import com.timesoft.shoppinglist.entities.NoteItem
import com.timesoft.shoppinglist.entities.ShopListItem
import com.timesoft.shoppinglist.entities.ShopListNameItem

@Database(
    entities = [LibraryItem::class, NoteItem::class,
        ShopListItem::class, ShopListNameItem::class], version = 1
)
abstract class MainDatabase : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null
        fun getDataBase(context: Context): MainDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "shopping_list.db"
                ).build()
                instance
            }
        }
    }

}