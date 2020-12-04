package br.com.digitalhouse.sqlliteandroidroom.Service

import br.com.digitalhouse.sqlliteandroidroom.dao.GastoDAO
import br.com.digitalhouse.sqlliteandroidroom.models.Gasto

interface Repository {

    suspend fun addGastoTask(gasto: Gasto)

    suspend fun getAllGastosTask(): List<Gasto>
}

class RepositoryImpl(val gastoDAO: GastoDAO): Repository{
    override suspend fun addGastoTask(gasto: Gasto) {
        gastoDAO.addGasto(gasto)
    }

    override suspend fun getAllGastosTask() = gastoDAO.getAllGastos()

}