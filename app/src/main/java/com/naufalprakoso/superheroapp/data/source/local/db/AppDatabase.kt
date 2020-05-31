package com.naufalprakoso.superheroapp.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naufalprakoso.superheroapp.data.source.local.entity.Hero
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import com.naufalprakoso.superheroapp.data.source.local.entity.Image
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat

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
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "Superhero.db"
                ).build()
            }
        }
    }
}