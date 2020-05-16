package com.naufalprakoso.superheroapp.data.source.local.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "biography",
    foreignKeys = [
        ForeignKey(entity = Hero::class, parentColumns = ["id"], childColumns = ["id"])
    ],
    indices = [Index("id")]
)
data class Biography(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    
    @ColumnInfo(name = "fullName")
    val fullName: String,

    @ColumnInfo(name = "alterEgos")
    val alterEgos: String,

    @ColumnInfo(name = "aliases")
    val aliases: String,

    @ColumnInfo(name = "placeOfBirth")
    val placeOfBirth: String,

    @ColumnInfo(name = "firstAppearance")
    val firstAppearance: String,

    @ColumnInfo(name = "publisher")
    val publisher: String?,

    @ColumnInfo(name = "alignment")
    val alignment: String
)