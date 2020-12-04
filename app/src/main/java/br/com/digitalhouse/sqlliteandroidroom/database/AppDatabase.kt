package br.com.digitalhouse.sqlliteandroidroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.digitalhouse.sqlliteandroidroom.models.Gasto

@Database(entities = [Gasto::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    companion object{
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "wallet.db"
        ).build()
    }

}
