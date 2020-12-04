package br.com.digitalhouse.sqlliteandroidroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.digitalhouse.sqlliteandroidroom.Service.Repository
import br.com.digitalhouse.sqlliteandroidroom.database.AppDatabase
import br.com.digitalhouse.sqlliteandroidroom.models.Gasto
import br.com.digitalhouse.sqlliteandroidroom.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    //    private lateinit var databaseHandler: DatabaseHandler
    private lateinit var db: AppDatabase
    private lateinit var repo: Repository ///


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        databaseHandler = DatabaseHandler(this)
//
//        val listGasto: List<Gasto> = databaseHandler.getAllGastos()
//        listGasto.forEach{
//            Log.i("MainActivity", it.toString())
//        }
//        val gasto = Gasto(2,"Comida", 10.0)
//        val res = databaseHandler.addGasto(gasto)
//
//        Log.i("MainActivity", res.toString())

        initDB()

        val viewModel by viewModels<MainViewModel>{
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(repo) as T
                }

            }
        }

        viewModel.addNewGasto(Gasto(1, "Comida", 10.0))
        viewModel.listGasto.observe(this){
            it.forEach {
                Log.i("MainActivity", it.toString())
            }
        }
    }

    fun initDB() {
        db = AppDatabase.invoke(this)

    }
}