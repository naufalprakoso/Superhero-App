package com.naufalprakoso.superheroapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "image",
    foreignKeys = [
        ForeignKey(entity = Hero::class, parentColumns = ["id"], childColumns = ["id"])
    ],
    indices = [Index("id")]
)
data class Image(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "xs")
    val xs: String,

    @ColumnInfo(name = "sm")
    val sm: String,

    @ColumnInfo(name = "md")
    val md: String,

    @ColumnInfo(name = "lg")
    val lg: String
)