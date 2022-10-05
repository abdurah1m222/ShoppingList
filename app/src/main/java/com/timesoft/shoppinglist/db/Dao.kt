package com.timesoft.shoppinglist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.timesoft.shoppinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Query ("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>

    @Query ("DELETE FROM note_list WHERE id IS :id")
    suspend fun deleteNote(id: Int)

    @Insert
    suspend fun insertNote(note: NoteItem)

}