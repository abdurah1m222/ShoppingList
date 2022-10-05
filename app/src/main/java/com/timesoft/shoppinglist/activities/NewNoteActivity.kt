package com.timesoft.shoppinglist.activities

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import com.timesoft.shoppinglist.R
import com.timesoft.shoppinglist.databinding.ActivityNewNoteBinding
import com.timesoft.shoppinglist.entities.NoteItem
import com.timesoft.shoppinglist.fragments.NoteFragment
import java.util.*

class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.id_save) {
            setMainResult()
        } else if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setMainResult() {
        val i = Intent().apply {
            putExtra(NoteFragment.NEW_NOTE_KEY, createNewNote())
        }
        setResult(RESULT_OK, i)
        finish()
    }

    private fun getCurrentTime(): String {
        val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        } else {
            TODO("VERSION.SDK_INT < N")
        }
        return formatter.format(Calendar.getInstance().time)
    }

    /*@RequiresApi(Build.VERSION_CODES.N)
    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }*/

    private fun createNewNote(): NoteItem {
        return NoteItem(
            null,
            binding.edTitle.text.toString(),
            binding.edDescription.text.toString(),
            getCurrentTime(),
            ""
        )
    }

    private fun actionBarSettings() {
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }

}