package com.naufalprakoso.superheroapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "power_stat",
    foreignKeys = [
        ForeignKey(entity = Hero::class, parentColumns = ["id"], childColumns = ["id"])
    ],
    indices = [Index("id")]
)
data class PowerStat(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "intelligence")
    val intelligence: Int,

    @ColumnInfo(name = "strength")
    val strength: Int,

    @ColumnInfo(name = "speed")
    val speed: Int,

    @ColumnInfo(name = "durability")
    val durability: Int,

    @ColumnInfo(name = "power")
    val power: Int,

    @ColumnInfo(name = "combat")
    val combat: Int
)