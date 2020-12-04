package br.com.digitalhouse.sqlliteandroidroom.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.sqlliteandroidroom.Service.Repository
import br.com.digitalhouse.sqlliteandroidroom.models.Gasto
import kotlinx.coroutines.launch

class MainViewModel (val repository: Repository): ViewModel(){
    val listGasto = MutableLiveData<List<Gasto>>()

    //Adicionar um novo gasto

    fun addNewGasto(gasto: Gasto){
        viewModelScope.launch {
            repository.addGastoTask(gasto)
        }

    }


    //Exibir a lista de Gastos
    fun getAllGastos(){
        viewModelScope.launch {
            listGasto.value = repository.getAllGastosTask()
        }

    }

}