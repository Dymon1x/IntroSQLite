package br.com.digitalhouse.sqlliteandroidroom.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gastos")
data class Gasto(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
//    @ColumnInfo(name = "nomes") nome da coluna no banco
    val nome: String,
    val valor: Double)