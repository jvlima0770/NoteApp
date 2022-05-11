package br.senac.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.databinding.ActivityNewNoteBinding
import br.senac.noteapp.date.AppDatabase
import br.senac.noteapp.date.Note
import br.senac.noteapp.date.Notes
import kotlin.system.exitProcess

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAdd.setOnClickListener{
            val note = Note(title = binding.etTitle.text.toString(),
                            desc = binding.etDesc.text.toString())

            //Jeito antigo abaixo
            //Notes.listaNotes.add(note)
            Thread{
                insertNote(note)
                finish()
            }.start()


        }
    }
    fun insertNote(note: Note){
        val db = Room.databaseBuilder(this,
            AppDatabase::class.java,"db").build()

        db.DAONote().insert(note)
    }

}