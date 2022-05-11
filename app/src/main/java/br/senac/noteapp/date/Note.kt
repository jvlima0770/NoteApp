package br.senac.noteapp.date

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(@PrimaryKey(autoGenerate = true) var id: Int? = null, var title: String,@ColumnInfo(name = "Descricao") var desc: String)