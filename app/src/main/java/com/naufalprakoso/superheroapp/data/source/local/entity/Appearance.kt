package com.naufalprakoso.superheroapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "appearance",
    foreignKeys = [
        ForeignKey(entity = Hero::class, parentColumns = ["id"], childColumns = ["id"])
    ],
    indices = [Index("id")]
)
data class Appearance(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "race")
    val race: String?,

    @ColumnInfo(name = "height")
    val height: String,

    @ColumnInfo(name = "weight")
    val weight: String,

    @ColumnInfo(name = "eyeColor")
    val eyeColor: String,

    @ColumnInfo(name = "hairColor")
    val hairColor: String
)