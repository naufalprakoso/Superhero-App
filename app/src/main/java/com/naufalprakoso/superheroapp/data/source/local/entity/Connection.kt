package com.naufalprakoso.superheroapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "connection",
    foreignKeys = [
        ForeignKey(entity = Hero::class, parentColumns = ["id"], childColumns = ["id"])
    ],
    indices = [Index("id")]
)
data class Connection(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "groupAffiliation")
    val groupAffiliation: String,

    @ColumnInfo(name = "relatives")
    val relatives: String
)