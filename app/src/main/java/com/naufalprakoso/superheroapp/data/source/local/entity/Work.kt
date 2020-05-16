package com.naufalprakoso.superheroapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "work",
    foreignKeys = [
        ForeignKey(entity = Hero::class, parentColumns = ["id"], childColumns = ["id"])
    ],
    indices = [Index("id")]
)
data class Work(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "occupation")
    val occupation: String,

    @ColumnInfo(name = "base")
    val base: String
)