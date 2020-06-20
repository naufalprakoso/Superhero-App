package com.naufalprakoso.superheroapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naufalprakoso.superheroapp.database.dao.HeroDao
import com.naufalprakoso.superheroapp.database.entity.Hero
import com.naufalprakoso.superheroapp.database.entity.Work
import com.naufalprakoso.superheroapp.database.entity.Appearance
import com.naufalprakoso.superheroapp.database.entity.Biography
import com.naufalprakoso.superheroapp.database.entity.Connection
import com.naufalprakoso.superheroapp.database.entity.Image
import com.naufalprakoso.superheroapp.database.entity.PowerStat

@Database(
    entities = [
        Hero::class,
        Work::class,
        Appearance::class,
        Biography::class,
        Connection::class,
        Image::class,
        PowerStat::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao

    companion object {
        private const val databaseName = "Superhero.db"

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                databaseName
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}