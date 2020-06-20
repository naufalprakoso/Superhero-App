package com.naufalprakoso.superheroapp.database.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Transaction
import androidx.room.OnConflictStrategy
import com.naufalprakoso.superheroapp.database.entity.Hero
import com.naufalprakoso.superheroapp.database.entity.Work
import com.naufalprakoso.superheroapp.database.entity.Biography
import com.naufalprakoso.superheroapp.database.entity.Appearance
import com.naufalprakoso.superheroapp.database.entity.Image
import com.naufalprakoso.superheroapp.database.entity.Connection
import com.naufalprakoso.superheroapp.database.entity.PowerStat
import com.naufalprakoso.superheroapp.database.relation.Superhero

@Dao
interface HeroDao {
    @Transaction
    @Query("SELECT * FROM superhero WHERE alignment = 'good'")
    fun getHeroes(): DataSource.Factory<Int, Superhero>

    @Transaction
    @Query("SELECT * FROM superhero WHERE alignment = 'bad'")
    fun getVillains(): DataSource.Factory<Int, Superhero>

    @Transaction
    @Query("SELECT * FROM superhero WHERE alignment = 'neutral' OR alignment = '-'")
    fun getAntiHeroes(): DataSource.Factory<Int, Superhero>

    @Transaction
    @Query("SELECT * FROM superhero WHERE id = :id")
    fun getById(id: Long): LiveData<Superhero>

    @Transaction
    suspend fun insertSuperheroes(
        heroes: List<Hero>,
        powerStats: List<PowerStat>,
        works: List<Work>,
        biographies: List<Biography>,
        connections: List<Connection>,
        images: List<Image>,
        appearances: List<Appearance>
    ) {
        insertHeroes(heroes)
        insertPowerStats(powerStats)
        insertWorks(works)
        insertBiographies(biographies)
        insertConnections(connections)
        insertImages(images)
        insertAppearances(appearances)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(data: List<Hero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPowerStats(data: List<PowerStat>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(data: List<Image>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppearances(data: List<Appearance>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBiographies(data: List<Biography>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConnections(data: List<Connection>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorks(data: List<Work>)
}