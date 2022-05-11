package br.senac.noteapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.databinding.ActivityListNotesBinding
import br.senac.noteapp.databinding.CardNoteBinding
import br.senac.noteapp.date.AppDatabase
import br.senac.noteapp.date.Note
import br.senac.noteapp.date.Notes

class ListNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener{
            val i = Intent(this, NewNoteActivity::class.java)
            startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        updateNotes()
    }

    fun updateNotes(){
        Thread{
            val db = Room.databaseBuilder(this,
                AppDatabase::class.java,"db").build()

            val list = db.DAONote().listAll()

            runOnUiThread{
                updateUi(list)
            }
        }.start()
    }

    fun updateUi(list: List<Note>){
        binding.container.removeAllViews()

        list.forEach{
            val card = CardNoteBinding.inflate(layoutInflater)

            card.textTitle.text = it.title
            card.textDesc.text = it.desc

            binding.container.addView(card.root)
        }
    }
}