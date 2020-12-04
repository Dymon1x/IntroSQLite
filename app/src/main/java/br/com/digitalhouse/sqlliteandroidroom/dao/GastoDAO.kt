package br.com.digitalhouse.sqlliteandroidroom.dao

import androidx.room.Insert
import androidx.room.Query
import br.com.digitalhouse.sqlliteandroidroom.models.Gasto

interface GastoDAO {

    @Insert
    suspend fun addGasto(gasto: Gasto)

    @Query("SELECT * FROM gastos")
    suspend fun getAllGastos():List<Gasto>


}