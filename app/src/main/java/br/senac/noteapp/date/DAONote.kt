package br.senac.noteapp.date

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAONote {
    @Insert
    fun insert(note: Note)

    @Query(value = "SELECT * FROM Note")
    fun listAll (): List<Note>
}