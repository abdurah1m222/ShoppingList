package com.timesoft.shoppinglist.db

import androidx.lifecycle.*
import com.timesoft.shoppinglist.entities.NoteItem
import kotlinx.coroutines.launch

class MainViewModel(database: MainDatabase) : ViewModel() {
    val dao = database.getDao()
    val allNotes: LiveData<List<NoteItem>> = dao.getAllNotes().asLiveData()

    fun insertNote(note: NoteItem) = viewModelScope.launch {
        dao.insertNote(note)
    }

    class MainViewModelFactory(val database: MainDatabase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {//override fun <T : ViewModel?> create(modelClass: Class<T>): T { -> ?
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw java.lang.IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}