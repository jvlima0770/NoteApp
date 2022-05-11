package br.senac.noteapp.date

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun DAONote(): DAONote
}